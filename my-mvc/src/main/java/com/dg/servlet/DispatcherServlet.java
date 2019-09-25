package com.dg.servlet;

import com.dg.annotation.*;
import com.dg.servlet.handler.ServletHandler;
import com.dg.servlet.handler.ServletHandlerAdapter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;

/**
 * @description:
 * @author: lij
 * @create: 2019-09-25 12:11
 */
@NoArgsConstructor
@Slf4j
public class DispatcherServlet extends HttpServlet {

    private List<String> classNames = Lists.newArrayList();
    private ConcurrentHashMap<String,Object> beans = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String,Method> handleMap = new ConcurrentHashMap<>();


    /**启动web容器时**/
    public void init(ServletConfig servletConfig) throws ServletException {
        //扫描哪些包下的class需要实例化
        doScanPackages("com.dg");
        classNames.forEach(log::info);
        //实例化所有类
        doInstance();
        //注入依赖
        doDependencyInject();
        //建立url和控制器的映射关系
        handleMapper();
        handleMap.entrySet().forEach(handleEntry -> {
            log.info(handleEntry.getKey() +":" + handleEntry.getValue());
        });
    }

    /**
     * 建立url和控制器的映射关系
     * @return: void
     */
    private void handleMapper() {
        if(beans.isEmpty()){
            log.info("beans is empty");
            return;
        }
        for (Map.Entry<String, Object> beanEntry : beans.entrySet()) {
            Object instance = beanEntry.getValue();
            Class<?> clazz = instance.getClass();
            if(clazz.isAnnotationPresent(DgController.class)){
                DgRequestMapping dqRequestMapping = clazz.getAnnotation(DgRequestMapping.class);
                String rootUrl = dqRequestMapping.value();
                Method[] methods = clazz.getDeclaredMethods();
                for (Method method : methods) {
                    if(method.isAnnotationPresent(DgRequestMapping.class)){
                        DgRequestMapping methodRequestMapping = method.getAnnotation(DgRequestMapping.class);
                        String methodUrl = methodRequestMapping.value();
                        handleMap.put(rootUrl+methodUrl, method);
                    }else{
                        continue;
                    }
                }
            }
        }
    }

    /**
     * 注入依赖
     * @return: void
     */
    private void doDependencyInject() {
        if(beans.isEmpty()){
            log.info("beans is empty");
            return;
        }
        for (Map.Entry<String, Object> beanEntry : beans.entrySet()) {
            Object instance = beanEntry.getValue();
            Class<?> clazz = instance.getClass();
            try {
                if(clazz.isAnnotationPresent(DgController.class)){
                    Field[] fields = clazz.getDeclaredFields();
                    for (Field field : fields) {
                        if(field.isAnnotationPresent(DgQualifier.class)){
                            DgQualifier dgQualifier = field.getAnnotation(DgQualifier.class);
                            String denpendencyKey = dgQualifier.value();
                            field.setAccessible(true); //放开权限，允许对private属性设值

                            Object dependencyBean = beans.get(denpendencyKey);
                            field.set(instance, dependencyBean);
                        }else{
                            continue;
                        }
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 实例化所有类
     * @return: void
     */
    private void doInstance() {
        if(CollectionUtils.isEmpty(classNames)){
            log.info("dispatcher scan no packages");
            return;
        }
        //遍历扫描到的class全类名，通过反射创建对象
        for (String className : classNames) {
            String cn = className.replaceAll(".class", "");
            try {
                Class<?> clazz = Class.forName(cn);
                if(clazz.isAnnotationPresent(DgController.class)){ //如果类有注解
                    DgController dgController = clazz.getAnnotation(DgController.class);
                    Object instance = clazz.newInstance(); //拿到实例化的bean‘

                    DgRequestMapping dgRequestMapping = clazz.getAnnotation(DgRequestMapping.class);
                    String key = dgRequestMapping.value();
                    beans.put(key, instance);
                }else if(clazz.isAnnotationPresent(DgService.class)){ //如果类有注解
                    DgService dgService = clazz.getAnnotation(DgService.class);
                    Object instance = clazz.newInstance(); //拿到实例化的bean‘
                    String key = dgService.value();
                    beans.put(key, instance);
                }else if(clazz.isAnnotationPresent(DgComponent.class)){ //如果类有注解
                    DgComponent dgComponent = clazz.getAnnotation(DgComponent.class);
                    Object instance = clazz.newInstance(); //拿到实例化的bean‘
                    String key = dgComponent.value();
                    beans.put(key, instance);
                }else{
                    continue;
                }

            } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 扫描class
     * @param basePackages
     * @return: void
     */
    private void doScanPackages(String... basePackages) {
        //扫描编译完的项目路径下的class文件
        for (String basePackage : basePackages) {
            String packagePath = basePackage.replaceAll("\\.", "/"); //com.dg
            URL url = this.getClass().getClassLoader().getResource(packagePath);
            File baseFile = new File(url.getFile());
            for (String fileName : baseFile.list()) {
                String filePackagePath  = basePackage + "." + fileName; //包路径
                if(new File(url.getFile() + "/" + fileName).isDirectory()){
                    //如果是目录，递归
                    doScanPackages(filePackagePath);
                }else{
                    classNames.add(filePackagePath);
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //拿到客户端请求过来的地址
        String requestURI = req.getRequestURI();
        String contextPath = req.getContextPath(); //拿到项目名
        requestURI = requestURI.replaceAll(contextPath, "");
        log.info(requestURI);

        if(handleMap.containsKey(requestURI)){
            try {
                Method method = handleMap.get(requestURI);
                Object instacneController = beans.get("/" + requestURI.split("/")[1]);

                //调用策略处理器
                ServletHandler servletHandlerAdapter = (ServletHandler) beans.get("servletHandlerAdapter");
                Object[] args = servletHandlerAdapter.handle(req, resp, method, beans);
                method.invoke(instacneController, args);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }

    }
}

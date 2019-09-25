import com.enjoy.componentScan.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @description: ComponentScan测试用例
 * @author: lij
 * @create: 2019-09-14 00:32
 */
public class ComponentScanTest {
    @Test
    public void test1(){
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
        /*ioc容器里都有什么bean*/
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        Arrays.asList(beanDefinitionNames).forEach(System.out::println);
    }
}

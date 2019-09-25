package com.enjoy.servlet.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: lij
 * @create: 2019-09-24 14:35
 */
@WebServlet(value = "/asyncOrder", asyncSupported = true)
@Slf4j
public class AysncServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      log.info("主线程【{}】 开始{}", Thread.currentThread().getName(),System.currentTimeMillis());
        AsyncContext startAsync = req.startAsync();
        startAsync.start(new Runnable() {
            @Override
            public void run() {
                try {
                    log.info("副线程【{}】 开始", Thread.currentThread().getName(),System.currentTimeMillis());
                    doBusiness();
                    startAsync.complete();
                    AsyncContext asyncContext = req.getAsyncContext();
                    ServletResponse response = asyncContext.getResponse();
                    response.getWriter().write("order successfully");
                    log.info("副线程【{}】 结束{}", Thread.currentThread().getName(),System.currentTimeMillis());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
      log.info("主线程【{}】 结束{}", Thread.currentThread().getName(),System.currentTimeMillis());
      //主线程资源断开
    }

    private void doBusiness(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

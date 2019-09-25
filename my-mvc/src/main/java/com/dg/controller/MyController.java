package com.dg.controller;

import com.dg.annotation.DgController;
import com.dg.annotation.DgQualifier;
import com.dg.annotation.DgRequestMapping;
import com.dg.annotation.DgRequestParam;
import com.dg.service.MyService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @description:
 * @author: lij
 * @create: 2019-09-25 12:02
 */
@DgController
@DgRequestMapping("/my")
public class MyController {

    @DgQualifier("myService")
    private MyService myService;

    @DgRequestMapping("/query")
    public void query(@DgRequestParam("name") String name,@DgRequestParam("age") String age,
                      HttpServletRequest request, HttpServletResponse response){
        PrintWriter printWriter;
        try {
            String result = myService.query(name, age);
            printWriter = response.getWriter();
            printWriter.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

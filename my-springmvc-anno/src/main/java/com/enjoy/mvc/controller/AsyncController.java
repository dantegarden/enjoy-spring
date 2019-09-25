package com.enjoy.mvc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.UUID;
import java.util.concurrent.*;

/**
 * @description:
 * @author: lij
 * @create: 2019-09-24 14:59
 */
@RequestMapping("/async")
@RestController
public class AsyncController {

    private static ConcurrentLinkedQueue<DeferredResult<String>> blockingQueue = new ConcurrentLinkedQueue<>();
    /**
     * 返回值是DeferredResult类型，如果没有结果请求阻塞
     *
     * @return
     */
    @GetMapping("/quotes")
    public DeferredResult<String> quotes() throws InterruptedException {
        //指定超时时间，以及出错时返回的值
        DeferredResult<String> result = new DeferredResult(50000L,"timeout error");
        blockingQueue.offer(result);
        return result;
    }

    @RequestMapping("/take")
    public String take() throws InterruptedException {
        //创建订单
        String orderNum = UUID.randomUUID().toString();
        //拿出上面保存的DeferredResultQueue
        DeferredResult<String> deferredResult = blockingQueue.poll();
        deferredResult.setResult(orderNum); //设置订单号createOrder() 就会得到立即返回
        return "success===>orderNum:"+orderNum;
    }

    @RequestMapping("/call")
    public Callable<ResponseEntity<String>> call() throws InterruptedException {
        Callable<ResponseEntity<String>> callable = new Callable<ResponseEntity<String>>() {
            @Override
            public ResponseEntity<String> call() throws Exception {
                Thread.sleep(5000);
                return ResponseEntity.ok(UUID.randomUUID().toString());
            }
        };
        return callable;
    }

}

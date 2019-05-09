package com.ccut.xyd.Thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

//执行任务
@Slf4j
@Component
public class ThreadExecutor {


    @Autowired
    private ThreadPoolTaskExecutor crawlThreadPool;
    /**
     * 当前执行的任务数
     */
    public static volatile AtomicInteger sum = new AtomicInteger(0);

    public void submit(Runnable task){
        sum.getAndIncrement();
        log.info("当前正在执行{}个任务......",sum);
        crawlThreadPool.submit(task);
    }

    public static void main(String[] args) {
       sum.getAndIncrement();
        System.out.println(sum);
        ThreadExecutor.sum.getAndDecrement();
        System.out.println(sum);
    }
}

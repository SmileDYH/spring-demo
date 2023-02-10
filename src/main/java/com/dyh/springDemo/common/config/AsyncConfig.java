package com.dyh.springDemo.common.config;

import cn.hutool.core.thread.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * ThreadPoolConfig
 * completable-executor-
 */
@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean(name = "completableExecutorService")
    public ThreadPoolExecutor completableExecutorService() {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNamePrefix(
                "completable-thread-").build();
        return new ThreadPoolExecutor(10, 20, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024),
                namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
    }
}

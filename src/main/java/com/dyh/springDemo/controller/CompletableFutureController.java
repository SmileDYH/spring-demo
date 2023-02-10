package com.dyh.springDemo.controller;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.dyh.springDemo.common.utils.ExceptionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * description: CompletableFuture异步编程 Controller
 * author: dyh
 * date: 2023/2/10 17:12
 */
@RestController
@RequestMapping("/demo/completableFuture")
@Slf4j
public class CompletableFutureController {

    @Resource(name = "completableExecutorService")
    private ThreadPoolExecutor executorService;


    @GetMapping("/test")
    public void test(){
        long  startTime = System.currentTimeMillis();

        //线程1
        CompletableFuture<Map<Integer, Map<Long, String>>> stageAndGradeAndSubjectFuture = CompletableFuture.supplyAsync(() -> {
            log.info("getQuestionsByNumbers，获取学段学科：");
            String str = "{\"0\":{\"130000\":\"初中\",\"140000\":\"高中\",\"120000\":\"小学\"},\"1\":{\"11\":\"高二\",\"12\":\"高三\",\"1\":\"一年级\",\"2\":\"二年级\",\"3\":\"三年级\",\"4\":\"四年级\",\"5\":\"五年级\",\"6\":\"六年级\",\"7\":\"初一\",\"8\":\"初二\",\"9\":\"初三\",\"10\":\"高一\"},\"2\":{\"100001\":\"语文\",\"100002\":\"数学\",\"100003\":\"物理\",\"100004\":\"化学\",\"100015\":\"道德与法治\",\"100016\":\"英语\",\"100005\":\"生物\",\"100006\":\"历史\",\"100007\":\"政治\",\"100008\":\"地理\"}}";
            Map<Integer, Map<Long, String>> map =  (Map) JSON.parse(str);

            try {
                Thread.sleep(1000);
            }catch (Exception e){
                log.info("睡眠异常");
            }

//            int a = 1/0;
            return map;
        },executorService).exceptionally(err -> {
            log.error("获取学段学科异常，numberList={}", 1, ExceptionUtils.extractRealException(err));
            return null;
        });

        //线程2
        CompletableFuture<Map<Integer, Map<Long, String>>> stageAndGradeAndSubjectFuture1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                log.info("睡眠异常");
            }
            return new HashMap<>();
        },executorService);

        //join()
        CompletableFuture.allOf(stageAndGradeAndSubjectFuture, stageAndGradeAndSubjectFuture1).join();

        try {
            Map<Integer, Map<Long, String>> stageAndGradeAndSubjectMap = stageAndGradeAndSubjectFuture.get();
            log.info("获取学段学科列表：{}", JSONUtil.toJsonStr(stageAndGradeAndSubjectMap));
            Map<Long, String> stageMap = stageAndGradeAndSubjectMap.get("0");
            Map<Long, String> subjectMap = stageAndGradeAndSubjectMap.get("2");
            log.info("stageMap=={}, subjectMap=={}", stageMap, subjectMap);
//            Map<Integer, Map<Long, String>> stageAndGradeAndSubjectMap1 = stageAndGradeAndSubjectFuture1.get();
        }catch (Exception e){
            log.info("获取学段学科列表异常");
        }

        long  endTime = System.currentTimeMillis();
        log.info("总用时：{}", endTime - startTime);
    }
}

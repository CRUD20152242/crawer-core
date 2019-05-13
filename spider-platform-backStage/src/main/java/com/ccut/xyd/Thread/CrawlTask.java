package com.ccut.xyd.Thread;

import com.ccut.xyd.ParsePage;
import com.ccut.xyd.Po.TaskStatePo;
import com.ccut.xyd.VO.InitVo;
import com.ccut.xyd.crawer.StartCrawl;
import com.ccut.xyd.service.TaskStateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 封装爬虫任务
 */
@Slf4j
public class CrawlTask implements Runnable {

    private StartCrawl startCrawl;
    private InitVo initVo;
    private ParsePage parsePage;
    private TaskStateService taskStateService;
    public CrawlTask(StartCrawl startCrawl, InitVo initVo, ParsePage parsePage, TaskStateService taskStateService){
        this.startCrawl = startCrawl;
        this.initVo = initVo;
        this.parsePage = parsePage;
        this.taskStateService = taskStateService;
    }
    public void run() {
        int urls = 0;
        initVo.setUrls(urls);
        log.info("任务开始执行---任务名:{}",initVo.getSeed());
        startCrawl.startCrawl(initVo,parsePage);
        log.info("任务{} 执行完毕 ",initVo.getFileName());
        TaskStatePo task = new TaskStatePo();
        task.setState(1);
        task.setUrls(initVo.getUrls());
        task.setTaskId(initVo.toString().hashCode());
        taskStateService.updateState(task);
        ThreadExecutor.sum.getAndDecrement();
    }
}

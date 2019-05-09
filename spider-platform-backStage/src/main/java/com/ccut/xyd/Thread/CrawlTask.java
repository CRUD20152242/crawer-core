package com.ccut.xyd.Thread;

import com.ccut.xyd.VO.InitVo;
import com.ccut.xyd.crawer.StartCrawl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 封装爬虫任务
 */
@Slf4j
@Component
@Scope("prototype")
public class CrawlTask implements Runnable {

    private StartCrawl startCrawl;
    private InitVo initVo;
    public CrawlTask(StartCrawl startCrawl, InitVo initVo){
        this.startCrawl = startCrawl;
        this.initVo = initVo;
    }
    public void run() {
        log.info("任务开始执行---任务名:{}",initVo.getSeed());
        startCrawl.startCrawl(initVo);
//        执行完毕总任务数量减去1
        ThreadExecutor.sum.getAndDecrement();
    }
}

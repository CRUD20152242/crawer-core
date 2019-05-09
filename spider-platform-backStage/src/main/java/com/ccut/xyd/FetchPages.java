package com.ccut.xyd;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import com.ccut.xyd.crawer.StartCrawl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;


@Slf4j
public class FetchPages extends BreadthCrawler {

    @Autowired
    StartCrawl startCrawl;
    public FetchPages(String crawlPath, boolean autoParse){
        super(crawlPath,autoParse);
    }
//    页面处理解析  本系统不负责页面解析，仅仅专注与内容的获取
    public void visit(Page page, CrawlDatums crawlDatums) {
        String htmlPage = null;
        com.ccut.xyd.Model.Page content = new com.ccut.xyd.Model.Page();
        try {
            htmlPage = page.html();
            content.setHtmlpage(htmlPage);
            log.info("page = {}",htmlPage);
            startCrawl.setPage(content);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

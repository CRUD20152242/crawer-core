package com.ccut.xyd;

import cn.edu.hfut.dmic.webcollector.crawldb.DBManager;
import cn.edu.hfut.dmic.webcollector.crawler.Crawler;
import cn.edu.hfut.dmic.webcollector.fetcher.Executor;
import cn.edu.hfut.dmic.webcollector.model.CrawlDatum;
import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BerkeleyDBManager;
import com.ccut.xyd.VO.InitVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;

@Slf4j
public class FetchPagesUseJs {
    static {
        //禁用Selenium的日志
        Logger logger = Logger.getLogger("com.gargoylesoftware.htmlunit");
        logger.setLevel(Level.OFF);
    }

    public void  parsePage(InitVo initVo){
        Executor executor = new Executor() {
            public void execute(CrawlDatum crawlDatum, CrawlDatums crawlDatums) throws Exception {
//                HtmlUnitDriver driver = new HtmlUnitDriver();
//                driver.setJavascriptEnabled(true);
//                System.out.println("url == "+crawlDatum.url());
//                driver.get("https://www.oschina.net");
////                解析页面
//                WebElement element=driver.findElementByCssSelector("h2");
//                System.out.println("获取的文本时："+element.getText());
            }
        };
        DBManager dbManager = new BerkeleyDBManager("test");
        Crawler fetchPages = new Crawler(dbManager,executor);

        fetchPages.addSeed(initVo.getSeed());
        fetchPages.setThreads(Integer.valueOf(initVo.getThreads()));
        try {
            fetchPages.start(Integer.valueOf(initVo.getDeep()));
            log.info("启动爬虫成功");
        } catch (Exception e) {
            log.error("启动爬虫失败：initVo={}",initVo.toString());
            e.printStackTrace();
        }

    }

    //测试

    public static void main(String[] args) {
        FetchPagesUseJs fetchPagesUseJs = new FetchPagesUseJs();
        InitVo initVo = new InitVo();
        initVo.setSeed("https://www.oschina.net");
        initVo.setThreads("10");
        initVo.setDeep("1");
        fetchPagesUseJs.parsePage(initVo);
    }
}

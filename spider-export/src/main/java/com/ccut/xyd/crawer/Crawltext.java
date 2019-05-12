package com.ccut.xyd.crawer;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

public class Crawltext extends BreadthCrawler {

    public Crawltext(String crawlPath, boolean autoParse){
        super(crawlPath,autoParse);
    }
    @Override
    public void visit(Page page, CrawlDatums crawlDatums) {

    }

    public static void main(String[] args) {
        Crawltext crawltext = new Crawltext("go",true);
        //添加种子页面
        crawltext.addSeed(args[0]);
        //添加url过滤
        crawltext.addRegex(args[0]);

        try {
            crawltext.start(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

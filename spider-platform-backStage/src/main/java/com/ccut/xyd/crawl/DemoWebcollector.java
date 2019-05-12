package com.ccut.xyd.crawl;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;


public class DemoWebcollector extends BreadthCrawler {

    public DemoWebcollector(String str,boolean a){
        super(str,a);
    }
    public void visit(Page page, CrawlDatums next) {
        System.out.println(page.html());
    }
}

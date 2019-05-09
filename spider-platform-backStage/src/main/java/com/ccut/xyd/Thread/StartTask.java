package com.ccut.xyd.Thread;

import com.ccut.xyd.VO.InitVo;
import com.ccut.xyd.VO.MessageVo;
import com.ccut.xyd.crawer.StartCrawl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StartTask {

    @Autowired
    private StartCrawl startCrawl;
    @Autowired
    private ThreadExecutor threadExecutor;
    public MessageVo setCrawl(InitVo initVo){
        MessageVo messageVo = new MessageVo();

        try {
            CrawlTask crawlTask = new CrawlTask(startCrawl,initVo);
            threadExecutor.submit(crawlTask);
            messageVo.setMessage("success");
        } catch (Exception e) {
            e.printStackTrace();
            messageVo.setMessage("error");
        }
        return  messageVo;
    }

}

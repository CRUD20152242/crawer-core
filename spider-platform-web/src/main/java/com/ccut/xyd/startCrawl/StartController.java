package com.ccut.xyd.startCrawl;

import com.ccut.xyd.RootController;
import com.ccut.xyd.Thread.StartTask;
import com.ccut.xyd.VO.InitVo;
import com.ccut.xyd.VO.MessageVo;
import com.ccut.xyd.crawer.StartCrawl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class StartController extends RootController {

    @Autowired
    private StartTask startCrawl;
    /**
     * 接收前端参数，初始化任务
     * @param initVo
     * @return
     */
    @RequestMapping(value = "/startCrawl",method = RequestMethod.GET)
    @ResponseBody
    public MessageVo StartCrawl(InitVo initVo){
        MessageVo messageVo = new MessageVo();
        log.info("爬虫任务启动 initVo={}",initVo);
        try {
            messageVo = startCrawl.setCrawl(initVo);
        } catch (Exception e) {
            e.printStackTrace();
            messageVo.setMessage("error");
        }
        return messageVo;
    }
}

package com.ccut.xyd.Utils;

import com.ccut.xyd.Po.TaskStatePo;
import com.ccut.xyd.VO.InitVo;
import com.ccut.xyd.model.ParseTaskModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

/**
 * 参数转换工具类
 */
@Slf4j
public class ParameterTransferUtil {

    // initVo->taskstate
    public static TaskStatePo buildTaskState(InitVo initVo){
        TaskStatePo taskStatePo = new TaskStatePo();
        Long createTime  = System.currentTimeMillis();
        taskStatePo.setCreateTime(String.valueOf(createTime));
        taskStatePo.setTaskName(initVo.getFileName());
        int taskId = initVo.toString().hashCode();
        taskStatePo.setTaskId(taskId);
        taskStatePo.setUrl(initVo.getSeed());
        taskStatePo.setState(0);
        taskStatePo.setDeep(Integer.valueOf(initVo.getDeep()));
        return taskStatePo;
    }
    //initVo->ParseTaskModel
    public static ParseTaskModel buildTaskModel(InitVo initVo){
        ParseTaskModel taskModel = new ParseTaskModel();
        if (StringUtils.isEmpty(initVo.getSeed())||StringUtils.isEmpty(initVo.getFileName())){
            log.error("seed or fileName is null!!!!!!!!!!!!");
            return null;
        }
        taskModel.setSeed(initVo.getSeed());
        taskModel.setTaskName(initVo.getFileName());
        if(null!=initVo ||initVo.getRules().size()> 0){
            taskModel.setRules(initVo.getRules());
        }


//        设置规则
        if(!StringUtils.isEmpty(initVo.getRule1())){
            taskModel.setRule1(initVo.getRule1());
        }
        if(!StringUtils.isEmpty(initVo.getRule2())){
            taskModel.setRule2(initVo.getRule2());
        }
        if(!StringUtils.isEmpty(initVo.getRule3())){
            taskModel.setRule3(initVo.getRule3());
        }
        if(!StringUtils.isEmpty(initVo.getRule4())){
            taskModel.setRule4(initVo.getRule4());
        }
        if(!StringUtils.isEmpty(initVo.getRule5())){
            taskModel.setRule5(initVo.getRule5());
        }
        if(!StringUtils.isEmpty(initVo.getRule6())){
            taskModel.setRule6(initVo.getRule6());
        }
        if(!StringUtils.isEmpty(initVo.getRule7())){
            taskModel.setRule7(initVo.getRule7());
        }
        if(!StringUtils.isEmpty(initVo.getRule8())){
            taskModel.setRule8(initVo.getRule8());
        }
        if(!StringUtils.isEmpty(initVo.getRule9())){
            taskModel.setRule9(initVo.getRule9());
        }
        if(!StringUtils.isEmpty(initVo.getRule10())){
            taskModel.setRule10(initVo.getRule10());
        }

        return taskModel;
    }
}

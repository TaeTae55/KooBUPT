package com.controller;

import com.Services.ComputerRoomBiz;
import com.Services.InfoBiz;
import com.Services.imp.InfoBizImp;
import com.entity.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Controller
@Scope("prototype")
@RequestMapping(value="/Info")
public class InfoController {
    @Autowired
    private InfoBiz infoBiz;

    //ResponseBody表示不进行跳转直接打印
    @RequestMapping(value="/getSession",produces = "application/json;charset=UTF-8",method= RequestMethod.POST)
    @ResponseBody
    public String getSession(@RequestBody Map<String,Object> params) throws IOException{
        Info info = infoBiz.get();
        return info.getSession()+"";
    }

    //ResponseBody表示不进行跳转直接打印
    @RequestMapping(value="/setSession",produces = "application/json;charset=UTF-8",method= RequestMethod.POST)
    @ResponseBody
    public String setSession(@RequestBody Map<String,Object> params) throws IOException{
        String sessionStr = params.get("classes").toString();
        int session = Integer.parseInt(sessionStr.substring(0, sessionStr.length()-1));
        return infoBiz.setSession(session)+"";
    }

    //ResponseBody表示不进行跳转直接打印
    @RequestMapping(value="/getPeriod",produces = "application/json;charset=UTF-8",method= RequestMethod.POST)
    @ResponseBody
    public String getPeriod(@RequestBody Map<String,Object> params) throws IOException{
        Info info = infoBiz.get();
        return info.getPeriod()+"";
    }

    //ResponseBody表示不进行跳转直接打印
    @RequestMapping(value="/setPeriod",produces = "application/json;charset=UTF-8",method= RequestMethod.POST)
    @ResponseBody
    public String setPeriod(@RequestBody Map<String,Object> params) throws IOException{
        String periodStr = params.get("period").toString();
        int period = Integer.parseInt(periodStr.substring(0, periodStr.length()-1));
        return infoBiz.setPeriod(period)+"";
    }

    //ResponseBody表示不进行跳转直接打印
    @RequestMapping(value="/getRange",produces = "application/json;charset=UTF-8",method= RequestMethod.POST)
    @ResponseBody
    public String getRange(@RequestBody Map<String,Object> params) throws IOException{
        Info info = infoBiz.get();
        return info.getRange()+"";
    }

    //ResponseBody表示不进行跳转直接打印
    @RequestMapping(value="/setRange",produces = "application/json;charset=UTF-8",method= RequestMethod.POST)
    @ResponseBody
    public String setRange(@RequestBody Map<String,Object> params) throws IOException{
        String rangeStr = params.get("range").toString();
        int range = 0;
        if(rangeStr.equals("半小时")){
            range = 1;
        }else if(rangeStr.equals("一小时")){
            range = 2;
        }else if(rangeStr.equals("两小时")){
            range = 4;
        }else if(rangeStr.equals("六小时")){
            range = 12;
        }else if(rangeStr.equals("十二小时")){
            range = 24;
        }else if(rangeStr.equals("一天")){
            range = 48;
        }else if(rangeStr.equals("两天")){
            range = 96;
        }else if(rangeStr.equals("五天")){
            range = 240;
        }else if(rangeStr.equals("七天")){
            range = 336;
        }
        return infoBiz.setRange(range)+"";
    }

}

package com.controller;

import com.Services.ComputerRoomBiz;
import com.Services.CourseBiz;
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
@RequestMapping(value="/course")

public class CourseController {
    @Autowired
    private CourseBiz courseBiz;
    @RequestMapping(value="/ManualAdd",produces = "application/json;charset=UTF-8",method= RequestMethod.POST)
    @ResponseBody
    public String ManualImport(@RequestBody Map<String,Object> params) throws IOException {
        String nameReceive = params.get("name").toString();
        String aid=params.get("aid").toString();
        int startWeek=Integer.parseInt(params.get("startWeek").toString());
        int endWeek=Integer.parseInt(params.get("endWeek").toString());
        int startSession=Integer.parseInt(params.get("startSession").toString());
        int endSession=Integer.parseInt(params.get("endSession").toString());
        String flag=params.get("flag").toString();

        int i = courseBiz.ManualAdd(nameReceive,aid,startWeek,endWeek,startSession,endSession,flag);
        return i+"";
    }
}

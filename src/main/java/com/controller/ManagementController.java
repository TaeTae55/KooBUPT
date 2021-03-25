package com.controller;
import com.Services.ManagementBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


@Controller
@Scope("prototype")
@RequestMapping(value="/management")////
public class ManagementController {
    @Autowired
    private ManagementBiz managementBiz;

    //ResponseBody表示不进行跳转直接打印
    @RequestMapping(value="/LockRoom",produces = "application/json;charset=UTF-8",method= RequestMethod.POST)
    @ResponseBody
    public String LockRoom(@RequestBody Map<String,Object> params) throws IOException, ParseException {

        String campusReceive = params.get("campus").toString();
        String buildingReceive = params.get("building").toString();
        String roomnumReceive = params.get("roomID").toString();
        int weekReceive = Integer.parseInt(params.get("week").toString());//礼拜几

        String s = params.get("sessionToForbid").toString();
        int startSessionReceive=Integer.parseInt(String.valueOf(s.charAt(1)));//开始节数
        int endSessionReceive=Integer.parseInt(String.valueOf(s.charAt(s.length()-2)));//结束节数

        //int startSessionReceive = Integer.parseInt(params.get("startSession").toString());
        //int endSessionReceive = Integer.parseInt(params.get("endSession").toString());
        String aidReceive = params.get("administratorID").toString();//管理员账号

        //机房不可用的时间
        String dateStr = params.get("date").toString();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date d2 = null;
        d2 = format.parse(dateStr);
        java.sql.Date date = new java.sql.Date(d2.getTime());

        String Rid="";
        if(campusReceive.equals("校本部")){
            if(buildingReceive.equals("科研楼")){
                Rid="HK-"+roomnumReceive;
            }
        }else if(campusReceive.equals("沙河校区")){
            if(buildingReceive.equals("S楼")){
                Rid = "SS-"+roomnumReceive;
            }else if(buildingReceive.equals("N楼")){
                Rid = "SN-"+roomnumReceive;
            }
        }

        //管理员操作时间
        /*SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        Date d1 = null;
        d1 = df.parse(df.format(new Date()));
        java.sql.Date time = new java.sql.Date(d1.getTime());
*/      SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String time=df.format(new Date());
        int i = managementBiz.LockRoom(time, aidReceive, weekReceive, startSessionReceive , endSessionReceive, date,Rid);
        return i+"";
    }

    @RequestMapping(value="/FreeRoom",produces = "application/json;charset=UTF-8",method= RequestMethod.POST)
    @ResponseBody
    public String deleteRoomOne(@RequestBody Map<String,Object> params) throws IOException, ParseException {
        String campusReceive = params.get("campus").toString();
        String buildingReceive = params.get("building").toString();
        String roomnumReceive = params.get("room").toString();
        int startSessionReceive = Integer.parseInt(params.get("startSession").toString());
        int endSessionReceive = Integer.parseInt(params.get("endSession").toString());

        //机房不可用的时间
        String dateStr = params.get("date").toString();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date d = null;
        d = format.parse(dateStr);
        java.sql.Date date = new java.sql.Date(d.getTime());

        String Rid="";
        if(campusReceive.equals("校本部")){
            if(buildingReceive.equals("科研楼")){
                Rid="HK-"+roomnumReceive;
            }
        }else if(campusReceive.equals("沙河校区")){
            if(buildingReceive.equals("S楼")){
                Rid = "SS-"+roomnumReceive;
            }else if(buildingReceive.equals("N楼")){
                Rid = "SN-"+roomnumReceive;
            }
        }
        if(managementBiz.FreeRoom(date,Rid,startSessionReceive,endSessionReceive)){
            return 1+"";
        }else{
            return 0+"";
        }
    }

}

package com.controller;


import Util.ReservationSend;
import com.Services.SubscribeBiz;
import com.alibaba.fastjson.JSON;
import com.entity.Subscribe;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Scope("prototype")
@RequestMapping(value="/subscribe")
public class SubscribeController {
    @Autowired
    private SubscribeBiz subscribeBiz;

    //ResponseBody表示不进行跳转直接打印
    @RequestMapping(value="/showToday",produces = "application/json;charset=UTF-8",method= RequestMethod.POST)
    @ResponseBody
    public String showTodaySubscirbe(@RequestBody Map<String,Object> params) throws IOException, ParseException {
        String dateStr = params.get("date").toString();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d = null;
        d = format.parse(dateStr);
        java.sql.Date date = new java.sql.Date(d.getTime());
        List<Subscribe> subs = subscribeBiz.findToday(date);

        Map<String, Subscribe> map = new HashMap<>();
        for(int i = 0;i<subs.size();i++){
            map.put((i+1)+"", subs.get(i));
        }
        return map.toString();
    }

///////////////////////////////////////////////////////////////
    //ResponseBody表示不进行跳转直接打印
    @RequestMapping(value="/deleteSubscribe",produces = "application/json;charset=UTF-8",method= RequestMethod.POST)
    @ResponseBody
    public String deleteSubscribeOne(@RequestBody Map<String,Object> params) throws IOException, ParseException {
        String dateReceive = params.get("date").toString();
        String campusReceive = params.get("campus").toString();
        String roomnumReceive = params.get("roomnum").toString();
        String startSessionReceive = params.get("startSession").toString();
        String endSessionReceive = params.get("endSession").toString();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d = null;
        d = format.parse(dateReceive);
        java.sql.Date date = new java.sql.Date(d.getTime());
        int startSession = Integer.valueOf(startSessionReceive).intValue();
        int endSession = Integer.valueOf(endSessionReceive).intValue();
        if(subscribeBiz.deleteOne(date, campusReceive, roomnumReceive, startSession, endSession)){
            return 1+"";
        }else{
            return 0+"";
        }
    }

    ////2.21
    //ResponseBody表示不进行跳转直接打印
    @RequestMapping(value="/checkReservations",produces = "application/json;charset=UTF-8",method= RequestMethod.POST)
    @ResponseBody
    public String checkReservations(@RequestBody Map<String,Object> params) throws IOException, ParseException {
        List<Subscribe> subs = subscribeBiz.checkReservations();
        List<String> ReservationSendList = new ArrayList<>();
        for(int i=0;i<subs.size();i++){
            ReservationSend reservationSend=new ReservationSend();
            reservationSend.setAid(subs.get(i).getCourse().getAid());
            //2.24
            reservationSend.setAccount(subs.get(i).getCourse().getAccount().getName());//老师名字
            reservationSend.setTime(subs.get(i).getTime());
            reservationSend.setDate(subs.get(i).getDate());
            reservationSend.setWeek(subs.get(i).getWeek());
            reservationSend.setStartSession(subs.get(i).getStartSession());
            reservationSend.setEndSession(subs.get(i).getEndSession());
            reservationSend.setCampus(subs.get(i).getComputerRoom().getCampus());
            reservationSend.setBuilding(subs.get(i).getComputerRoom().getBuilding());
            reservationSend.setRoom(subs.get(i).getComputerRoom().getRoomnum());
            reservationSend.setName(subs.get(i).getCourse().getName());//课程名字
            String json= JSON.toJSONString(reservationSend);
            ReservationSendList.add(json);
        }
        return JSON.toJSONString(ReservationSendList);
        //return managementList.get(0).getEndSession()+"";
    }

    //2.24
    @RequestMapping(value="/pass",produces = "application/json;charset=UTF-8",method= RequestMethod.POST)
    @ResponseBody
    public String pass(@RequestBody Map<String,Object> params) throws IOException, ParseException {
        int cidReceive = Integer.parseInt(params.get("Cid").toString());//课程编号

        String campusReceive = params.get("campus").toString();
        String buildingReceive = params.get("building").toString();
        String roomnumReceive = params.get("room").toString();
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
        String RidReceive = Rid;//房间号

        String dateStr = params.get("date").toString();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d = null;
        d = format.parse(dateStr);
        java.sql.Date date = new java.sql.Date(d.getTime());
        int startSessionReceive = Integer.parseInt(params.get("startSession").toString());
        int endSessionReceive = Integer.parseInt(params.get("endSession").toString());

        return subscribeBiz.pass(cidReceive,RidReceive,date,startSessionReceive,endSessionReceive)+"";
    }
    @RequestMapping(value="/fail",produces = "application/json;charset=UTF-8",method= RequestMethod.POST)
    @ResponseBody
    public String fail(@RequestBody Map<String,Object> params) throws IOException, ParseException {
        int cidReceive = Integer.parseInt(params.get("Cid").toString());

        String campusReceive = params.get("campus").toString();
        String buildingReceive = params.get("building").toString();
        String roomnumReceive = params.get("room").toString();
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
        String RidReceive = Rid;//房间号

        String dateStr = params.get("date").toString();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d = null;
        d = format.parse(dateStr);
        java.sql.Date date = new java.sql.Date(d.getTime());
        int startSessionReceive = Integer.parseInt(params.get("startSession").toString());
        int endSessionReceive = Integer.parseInt(params.get("endSession").toString());

        return subscribeBiz.fail(cidReceive,RidReceive,date,startSessionReceive,endSessionReceive)+"";
    }
}

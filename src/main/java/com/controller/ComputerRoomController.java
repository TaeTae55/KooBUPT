package com.controller;

import Util.SituationRoomSend;
import com.Services.ComputerRoomBiz;
import com.Services.InfoBiz;
import com.Services.ManagementBiz;
import com.Services.SubscribeBiz;
import com.entity.ComputerRoom;
import com.entity.Info;
import com.entity.Management;
import com.entity.Subscribe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Util.SituationRoomReceive;

@Controller
@Scope("prototype")
@RequestMapping(value="/computerRoom")
public class ComputerRoomController {
    @Autowired
    private ComputerRoomBiz computerRoomBiz;

    @Autowired
    private ManagementBiz managementBiz;

    @Autowired
    private SubscribeBiz subscribeBiz;

    @Autowired
    private InfoBiz infoBiz;

    //ResponseBody表示不进行跳转直接打印
    @RequestMapping(value="/addRoom",produces = "application/json;charset=UTF-8",method= RequestMethod.POST)
    @ResponseBody
    public String addRoom(@RequestBody Map<String,Object> params) throws IOException {
        String campusReceive = params.get("campus").toString();
        String numberReceive = params.get("equipmentNum").toString();
        String buildingReceive = params.get("building").toString();
        String roomnumReceive = params.get("room").toString();

        String campus = "";
        String Rid="";
        int number = Integer.valueOf(numberReceive).intValue();
        if(campusReceive.equals("校本部")){
            campus = "H";
            if(buildingReceive.equals("科研楼")){
                Rid="HK-"+roomnumReceive;
            }
        }else if(campusReceive.equals("沙河校区")){
            campus = "S";
            if(buildingReceive.equals("S楼")){
                Rid = "SS-"+roomnumReceive;
            }else if(buildingReceive.equals("N楼")){
                Rid = "SN-"+roomnumReceive;
            }
        }
        int i = computerRoomBiz.addRoom(campus, Rid, number, 1, buildingReceive, roomnumReceive);
        return i+"";
    }

    @RequestMapping(value="/showRooms",produces = "application/json;charset=UTF-8",method= RequestMethod.POST)
    @ResponseBody
    public String showRooms(@RequestBody Map<String,Object> params) throws IOException {
        Map<String, String> map = new HashMap<>();
        List<String> roomList = new ArrayList<>();
        List<ComputerRoom> rooms = computerRoomBiz.findAllRoom();
        for(int i = 0;i<rooms.size();i++){
            String json=JSON.toJSONString(rooms.get(i));
            map.put((i+1)+"", json);
            roomList.add(json);
        }

        //return JSON.toJSONString(roomList.toString());
        return JSON.toJSONString(roomList);
        //return roomList.toString();

    }

    @RequestMapping(value="/deleteRoom",produces = "application/json;charset=UTF-8",method= RequestMethod.POST)
    @ResponseBody
    public String deleteRoomOne(@RequestBody Map<String,Object> params) throws IOException {
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
        if(computerRoomBiz.deleteRoomOne(Rid)){
            return 1+"";
        }else{
            return 0+"";
        }
    }

    @RequestMapping(value="/sendRoomId",produces = "application/json;charset=UTF-8",method= RequestMethod.POST)
    @ResponseBody
    public String sendRoomId(@RequestBody Map<String,Object> params) throws IOException{
        String session = infoBiz.get().getSession()+"";
        String campusReceive = params.get("campus").toString();
        String campus="";
        if(campusReceive.equals("校本部")){
            campus ="H";
        }else if(campusReceive.equals("沙河校区")){
            campus = "S";
        }
        List<ComputerRoom> computerRoomList = computerRoomBiz.findRoomByFCB(campus, Integer.parseInt(params.get("floor").toString()), params.get("building").toString());
        List<String> sendList = new ArrayList<>();
        sendList.add(session);
        for(int i=0;i<computerRoomList.size();i++){
            sendList.add(computerRoomList.get(i).getRoomnum());
        }
        return JSON.toJSONString(sendList.toString());
    }

    @RequestMapping(value="/showSituation",produces = "application/json;charset=UTF-8",method= RequestMethod.POST)
    @ResponseBody
    public String showSituation(@RequestBody Map<String,Object> params) throws IOException, ParseException {
        SituationRoomReceive situationRoom = new SituationRoomReceive();
        String dateReceive = params.get("date").toString();

        String campusReceive = params.get("campus").toString();
        String campus="";
        if(campusReceive.equals("校本部")){
            campus ="H";
        }else if(campusReceive.equals("沙河校区")){
            campus = "S";
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d = null;
        d = format.parse(dateReceive);
        java.sql.Date date = new java.sql.Date(d.getTime());
        situationRoom.setBuilding(params.get("building").toString());
        situationRoom.setCampus(campus);
        situationRoom.setFloor(Integer.parseInt(params.get("floor").toString()));
        situationRoom.setDate(date);

        List<Management> managementList = managementBiz.getRoomManagement(situationRoom);
        List<Subscribe> subscribeList = subscribeBiz.getRoomSubscribe(situationRoom);
        List<String> situationRoomSendList = new ArrayList<>();

        for(int i=0;i<managementList.size();i++){
            SituationRoomSend situationRoomSend = new SituationRoomSend();
            situationRoomSend.setId(managementList.get(i).getComputerRoom().getRoomnum());
            situationRoomSend.setStartSession(managementList.get(i).getStartSession());
            situationRoomSend.setEndSession(managementList.get(i).getEndSession());
            situationRoomSend.setFlag("cannot");
            String json= JSON.toJSONString(situationRoomSend);
            situationRoomSendList.add(json);
        }
        for(int i = 0;i<subscribeList.size();i++){
            SituationRoomSend situationRoomSend = new SituationRoomSend();
            situationRoomSend.setId(subscribeList.get(i).getComputerRoom().getRoomnum());
            situationRoomSend.setStartSession(subscribeList.get(i).getStartSession());
            situationRoomSend.setEndSession(subscribeList.get(i).getEndSession());
            situationRoomSend.setFlag("already");
            String json= JSON.toJSONString(situationRoomSend);
            situationRoomSendList.add(json);
        }
        return JSON.toJSONString(situationRoomSendList);
        //return managementList.get(0).getEndSession()+"";

    }
}

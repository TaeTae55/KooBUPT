package com.Services.imp;

import Util.SituationRoomReceive;
import com.Services.ManagementBiz;
import com.entity.Management;
import com.mapper.ManagementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

@Service("managementBiz")
public class ManagementBizImp implements ManagementBiz {

    @Autowired
    private ManagementMapper managementMapper;

    @Override
    public List<Management> getRoomManagement(SituationRoomReceive situationRoom) throws IOException {
        return managementMapper.getRoomManagement(situationRoom);
    }

    @Override
    public int LockRoom(String time, String aid, int week, int startSession, int endSession, Date date, String Rid) throws IOException {
        Management management=new Management();
        management.setTime(time);//.....
        management.setAid(aid);
        management.setWeek(week);
        management.setStartSession(startSession);
        management.setEndSession(endSession);
        management.setDate(date);
        management.setRid(Rid);
        return managementMapper.LockRoom(management);
    }

    @Override
    public boolean FreeRoom(Date date,String Rid,int startSession, int endSession) throws IOException{
        Management management=new Management();
        management.setStartSession(startSession);
        management.setEndSession(endSession);
        management.setDate(date);
        management.setRid(Rid);
        return managementMapper.FreeRoom(management);
    }
}

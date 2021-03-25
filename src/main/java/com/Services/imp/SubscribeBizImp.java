package com.Services.imp;

import Util.SituationRoomReceive;
import com.Services.SubscribeBiz;
import com.entity.Subscribe;
import com.mapper.SubscribeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

@Service("subscribeBiz")
public class SubscribeBizImp implements SubscribeBiz {

    @Autowired
    private SubscribeMapper subscribeMapper;

    @Override
    public List<Subscribe> findToday(Date date) throws IOException {
        return subscribeMapper.findToday(date);
    }

    /////////////////////////////////////////////////////
    @Override
    public boolean deleteOne(Date date, String campus, String roomnum, int startSession, int endSession) throws IOException {
        String Rid = "";
        if(campus.equals("校本部")){

        }else if(campus.equals("沙河校区")){

        }
        Subscribe subscribe = new Subscribe();
        subscribe.setDate(date);
        subscribe.setRid(Rid);
        subscribe.setStartSession(startSession);
        subscribe.setEndSession(endSession);

        return subscribeMapper.deleteOne(subscribe);

    }

    @Override
    public List<Subscribe> getRoomSubscribe(SituationRoomReceive situationRoom) throws IOException {
        return subscribeMapper.getRoomSubscribe(situationRoom);
    }

    /////////2.21
    @Override
    public List<Subscribe> checkReservations() throws IOException {
        return subscribeMapper.checkReservations();
    }

    ///2.24
    @Override
    public int pass(int Cid, String Rid, Date date, int startSession, int endSession) throws IOException{
        Subscribe subscribe = new Subscribe();
        subscribe.setDate(date);
        subscribe.setRid(Rid);
        subscribe.setCid(Cid);
        subscribe.setStartSession(startSession);
        subscribe.setEndSession(endSession);
        return subscribeMapper.pass(subscribe);
    }
    @Override
    public int fail(int Cid, String Rid, Date date, int startSession, int endSession) throws IOException{
        Subscribe subscribe = new Subscribe();
        subscribe.setDate(date);
        subscribe.setRid(Rid);
        subscribe.setCid(Cid);
        subscribe.setStartSession(startSession);
        subscribe.setEndSession(endSession);
        return subscribeMapper.pass(subscribe);
    }
}

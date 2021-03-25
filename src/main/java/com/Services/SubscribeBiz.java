package com.Services;

import Util.SituationRoomReceive;
import com.entity.Subscribe;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

public interface SubscribeBiz {
    public List<Subscribe> findToday(Date date) throws IOException;
    public boolean deleteOne(Date date, String campus, String roomnum, int startSession, int endSession) throws IOException;
    public List<Subscribe> getRoomSubscribe(SituationRoomReceive situationRoom) throws IOException;
    public List<Subscribe> checkReservations() throws IOException;

//2.24
    public int pass(int Cid, String Rid, Date date, int startSession, int endSession) throws IOException;
    public int fail(int Cid, String Rid, Date date, int startSession, int endSession) throws IOException;
}

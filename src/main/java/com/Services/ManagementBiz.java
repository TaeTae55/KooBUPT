package com.Services;

import Util.SituationRoomReceive;
import com.entity.Management;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

public interface ManagementBiz {
    public List<Management> getRoomManagement(SituationRoomReceive situationRoom) throws IOException;
    public int LockRoom(String time, String aid, int week, int startSession, int endSession,Date date,String Rid) throws IOException;
    public boolean FreeRoom(Date date, String Rid, int startSession, int endSession) throws IOException;
}

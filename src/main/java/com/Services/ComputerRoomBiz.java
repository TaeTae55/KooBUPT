package com.Services;

import com.entity.ComputerRoom;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.util.List;

public interface ComputerRoomBiz {
    public int addRoom(String campus, String Rid, int number, int floor, String building, String roomnum) throws IOException;
    public List<ComputerRoom> findAllRoom() throws IOException;
    public boolean deleteRoomOne(String Rid) throws IOException;
    public List<ComputerRoom> findRoomByFCB(String campus, int floor, String building) throws IOException;

}

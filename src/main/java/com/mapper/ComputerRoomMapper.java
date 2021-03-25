package com.mapper;

import com.entity.ComputerRoom;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.apache.ibatis.annotations.Mapper;

import java.io.IOException;
import java.util.List;

@Mapper
public interface ComputerRoomMapper {
//    public List<ComputerRoom> findAllInShaHe() throws IOException;
//    public List<ComputerRoom> findAllInHaiDian() throws IOException;
//    public List<ComputerRoom> findAllFitRoomsInHaiDian(int num) throws IOException;
//    public List<ComputerRoom> findAllFitRoomsInShaHe(int num) throws IOException;
//    public List<ComputerRoom> ListAllRoomsOnAFloorInS(int floor) throws IOException;
//    public List<ComputerRoom> ListAllRoomsOnAFloorInH(int floor) throws IOException;
    public List<ComputerRoom> findAllRoom() throws IOException;
    public int addRoom(ComputerRoom computerRoom) throws IOException;
    public boolean deleteRoomOne(ComputerRoom computerRoom) throws IOException;
    public int selectRoomOne(ComputerRoom computerRoom) throws IOException;
    public List<ComputerRoom> findRoomByFCB(ComputerRoom computerRoom) throws IOException;
}

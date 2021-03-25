package com.Services.imp;

import com.Services.ComputerRoomBiz;
import com.entity.ComputerRoom;
import com.mapper.AccountMapper;
import com.mapper.ComputerRoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service("computerroomBiz")
public class ComputerRoomBizImp implements ComputerRoomBiz {

    @Autowired
    private ComputerRoomMapper computerRoomMapper;

    public int addRoom(String campus, String Rid, int number, int floor, String building, String roomnum) throws IOException {
        ComputerRoom room = new ComputerRoom();
        room.setCampus(campus);
        room.setRid(Rid);
        room.setNumber(number);
        room.setBuilding(building);
        room.setFloor(floor);
        room.setRoomnum(roomnum);
        return computerRoomMapper.addRoom(room);
    }
    public List<ComputerRoom> findAllRoom() throws IOException{
        return computerRoomMapper.findAllRoom();
    }

    @Override
    public boolean deleteRoomOne(String Rid) throws IOException {
        ComputerRoom computerRoom = new ComputerRoom();
        computerRoom.setRid(Rid);
        return computerRoomMapper.deleteRoomOne(computerRoom);
    }

    @Override
    public List<ComputerRoom> findRoomByFCB(String campus, int floor, String building) throws IOException {
        ComputerRoom computerRoom = new ComputerRoom();
        computerRoom.setFloor(floor);
        computerRoom.setBuilding(building);
        computerRoom.setCampus(campus);
        return computerRoomMapper.findRoomByFCB(computerRoom);
    }
}

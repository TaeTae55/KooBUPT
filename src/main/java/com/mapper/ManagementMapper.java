package com.mapper;

import Util.SituationRoomReceive;
import com.entity.Management;
import org.apache.ibatis.annotations.Mapper;

import java.io.IOException;
import java.util.List;

@Mapper
public interface ManagementMapper {
    public List<Management> getRoomManagement(SituationRoomReceive situationRoom) throws IOException;
    public int LockRoom(Management management) throws IOException;
    public boolean FreeRoom(Management management) throws IOException;
}

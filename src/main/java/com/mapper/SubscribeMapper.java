package com.mapper;

import Util.SituationRoomReceive;
import com.entity.Subscribe;
import org.apache.ibatis.annotations.Mapper;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

@Mapper
public interface SubscribeMapper {
    public List<Subscribe> findToday(Date date) throws IOException;
    public boolean deleteOne(Subscribe subscribe) throws IOException;
    public List<Subscribe> getRoomSubscribe(SituationRoomReceive situationRoom) throws IOException;
    public List<Subscribe> checkReservations() throws IOException;

    public int pass(Subscribe subscribe) throws IOException;
    public int fail(Subscribe subscribe) throws IOException;
}

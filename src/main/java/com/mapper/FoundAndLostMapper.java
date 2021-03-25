package com.mapper;

import com.entity.FoundAndLost;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FoundAndLostMapper {
    public List<FoundAndLost> findAllFound();
    public List<FoundAndLost> findAllLost();
}

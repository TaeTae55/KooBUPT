package com.mapper;

import com.entity.Info;
import org.apache.ibatis.annotations.Mapper;

import java.io.IOException;

@Mapper
public interface InfoMapper {
    public Info get() throws IOException;
    public int setSession(Info info) throws IOException;
    public int setPeriod(Info info) throws IOException;
    public int setRange(Info info) throws IOException;
}

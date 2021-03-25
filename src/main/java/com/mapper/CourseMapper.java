package com.mapper;

import com.entity.Account;
import com.entity.Course;
import org.apache.ibatis.annotations.Mapper;

import java.io.IOException;

@Mapper
public interface CourseMapper {
    public int ManualAdd(Course course) throws IOException;
}

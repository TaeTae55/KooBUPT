package com.Services.imp;

import com.Services.CourseBiz;
import com.entity.Course;
import com.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service("courseBiz")
public class CourseBizImp implements CourseBiz {
    @Autowired
    private CourseMapper courseDao;

    @Override
    public int ManualAdd(String name, String aid,int startWeek, int endWeek, int startSession,int endSession,String flag) throws IOException{
        Course course=new Course();
        course.setName(name);
        course.setAid(aid);
        course.setStartWeek(startWeek);
        course.setEndWeek(endWeek);
        course.setStartSession(startSession);
        course.setEndSession(endSession);
        course.setFlag(flag);
        return courseDao.ManualAdd(course);
    }
}

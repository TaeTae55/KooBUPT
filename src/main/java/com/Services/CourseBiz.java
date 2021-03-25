package com.Services;

import java.io.IOException;

public interface CourseBiz {
    public int ManualAdd(String name, String aid,int startWeek, int endWeek, int startSession,int endSession,String flag) throws IOException;
}

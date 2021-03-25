package com.Services;

import com.entity.Info;

import java.io.IOException;

public interface InfoBiz {
    public Info get() throws IOException;
    public int setSession(int session) throws IOException;
    public int setPeriod(int period) throws IOException;
    public int setRange(int range) throws IOException;
}

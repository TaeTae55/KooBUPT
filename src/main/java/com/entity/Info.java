package com.entity;

public class Info {
    private int iid;
    //一天有几节课
    private int session;
    //一节课有多长时间
    private int period;
    //能够修改时间的范围
    private int timeRange;

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public int getSession() {
        return session;
    }

    public void setSession(int session) {
        this.session = session;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getRange() {
        return timeRange;
    }

    public void setRange(int range) {
        this.timeRange = range;
    }
}

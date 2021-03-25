package com.entity;

import java.sql.Date;
import java.sql.Time;

public class Management {
    private int Mid;
    /*-----不确定类型----*/
    private String time;
    private Date date;
    private String aid;
    private String Rid;
    private int week;
    private int startSession;
    private int endSession;
    private ComputerRoom computerRoom;

    public ComputerRoom getComputerRoom() {
        return computerRoom;
    }

    public void setComputerRoom(ComputerRoom computerRoom) {
        this.computerRoom = computerRoom;
    }

    public String getRid() {
        return Rid;
    }

    public void setRid(String rid) {
        Rid = rid;
    }

    public int getMid() {
        return Mid;
    }

    public void setMid(int mid) {
        Mid = mid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getStartSession() {
        return startSession;
    }

    public void setStartSession(int startSession) {
        this.startSession = startSession;
    }

    public int getEndSession() {
        return endSession;
    }

    public void setEndSession(int endSession) {
        this.endSession = endSession;
    }

    @Override
    public String toString() {
        return "Management{" +
                "Mid=" + Mid +
                ", time=" + time +
                ", date=" + date +
                ", aid='" + aid + '\'' +
                ", week=" + week +
                ", startSession=" + startSession +
                ", endSession=" + endSession +
                '}';
    }
}

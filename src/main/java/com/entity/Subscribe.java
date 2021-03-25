package com.entity;

import java.sql.Date;
import java.sql.Time;

public class Subscribe {
    private String Rid;
    private Time time;
    private Date date;

    //2.24private String aid;
    private int Cid;
    private int week;
    private int startSession;
    private int endSession;
    private String academic;
    private String type;
    private int sid;
    private String flag;
    private ComputerRoom computerRoom;

    public ComputerRoom getComputerRoom() {
        return computerRoom;
    }

    public void setComputerRoom(ComputerRoom computerRoom) {
        this.computerRoom = computerRoom;
    }
//2.21
    private Course course;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }


//    //2.24
//    private Account account;
//
//    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getRid() {
        return Rid;
    }

    public void setRid(String rid) {
        Rid = rid;
    }

    public String getAcademic() {
        return academic;
    }

    public void setAcademic(String academic) {
        this.academic = academic;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
/*
    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }*/

    public int getCid() {
        return Cid;
    }

    public void setCid(int cid) {
        Cid = cid;
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
        return "Subscribe{" +
                "Rid=" + Rid +
                ", time=" + time +
                ", date=" + date +'\'' +
                ", Cid=" + Cid +
                ", week=" + week +
                ", startSession=" + startSession +
                ", endSession=" + endSession +
                '}';
    }
}

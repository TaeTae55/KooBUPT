package com.entity;

import java.util.List;

public class Course {
    /*-------------------------------*/
    private int Cid;
    private String cname;
    private int startWeek;
    private int endWeek;
    private String aid;
    private int startSession;
    private int endSession;
    private String flag;

    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Subscribe> getSubscribeList() {
        return subscribeList;
    }

    private List<Subscribe> subscribeList;

    public void setSubscribeList(List<Subscribe> subscribeList) {
        this.subscribeList = subscribeList;
    }

    public int getCid() {
        return Cid;
    }

    public void setCid(int cid) {
        Cid = cid;
    }

    public String getName() {
        return cname;
    }

    public void setName(String name) {
        this.cname = name;
    }

    public int getStartWeek() {
        return startWeek;
    }

    public void setStartWeek(int startWeek) {
        this.startWeek = startWeek;
    }

    public int getEndWeek() {
        return endWeek;
    }

    public void setEndWeek(int endWeek) {
        this.endWeek = endWeek;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
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

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Course{" +
                "Cid=" + Cid +
                ", name='" + cname + '\'' +
                ", startWeek=" + startWeek +
                ", endWeek=" + endWeek +
                ", aid=" + aid +
                ", startSession=" + startSession +
                ", endSession=" + endSession +
                ", flag='" + flag + '\'' +
                '}';
    }
}

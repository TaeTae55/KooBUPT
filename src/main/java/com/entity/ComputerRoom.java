package com.entity;

import java.util.List;

public class ComputerRoom {
    //---------------------------------------------
    private String Rid;//
    private int number;//设备数
    private String campus;//校区
    private String building;
    private String roomnum;
    private int floor;
    private List<Management> managementList;

    public List<Management> getManagementList() {
        return managementList;
    }

    public void setManagementList(List<Management> managementList) {
        this.managementList = managementList;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(String roomnum) {
        this.roomnum = roomnum;
    }



    @Override
    public String toString() {
        return "ComputerRoom{" +
                "Rid='" + Rid + '\'' +
                ", number=" + number +
                ", campus='" + campus + '\'' +
                ", building='" + building + '\'' +
                ", roomnum='" + roomnum + '\'' +
                ", floor=" + floor +
                '}';
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getRid() {
        return Rid;
    }

    public void setRid(String rid) {
        Rid = rid;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

}

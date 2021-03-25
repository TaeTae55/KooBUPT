package com.entity;


import java.util.List;

public class Account {
    private String aid;
    private String password;
    private String classes;
    private String aname;
    private int year;
    private String tel;
    private String Email;

    public String getAacademic() {
        return aacademic;
    }

    public void setAacademic(String aacademic) {
        this.aacademic = aacademic;
    }

    private String aacademic;
    //2.24
    /*public List<Subscribe> getSubscribeList() {
        return subscribeList;
    }

    private List<Subscribe> subscribeList;

    public void setSubscribeList(List<Subscribe> subscribeList) {
        this.subscribeList = subscribeList;
    }*/


    private List<Course> coursesList;

    public List<Course> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(List<Course> coursesList) {
        this.coursesList = coursesList;
    }
    ////

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getName() {
        return aname;
    }

    public void setName(String name) {
        this.aname = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "Account{" +
                "aid='" + aid + '\'' +
                ", password='" + password + '\'' +
                ", classes=" + classes +
                ", name='" + aname + '\'' +
                ", year=" + year +
                ", tel='" + tel + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}

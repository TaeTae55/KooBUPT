package com.entity;

public class FoundAndLost {
    private int Fid;
    private String aid;
    private String content;
    private String FORL;
    private String title;
    private String ltel;

    public int getFid() {
        return Fid;
    }

    public void setFid(int fid) {
        Fid = fid;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFORL() {
        return FORL;
    }

    public void setFORL(String FORL) {
        this.FORL = FORL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLtel() {
        return ltel;
    }

    public void setLtel(String ltel) {
        this.ltel = ltel;
    }

    @Override
    public String toString() {
        return "FoundAndLost{" +
                "Fid=" + Fid +
                ", aid=" + aid +
                ", content='" + content + '\'' +
                ", FORL='" + FORL + '\'' +
                ", title='" + title + '\'' +
                ", ltel='" + ltel + '\'' +
                '}';
    }
}

package com.hzitshop.vo.menuapp;

/**
 * Created by xianyaoji on 2017/7/9.
 */
public class MenuApp {
    private int id;
    private String name;
    private String pname;
    private String url;
    private int aiailable;
    private int pId;

    public MenuApp() {
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getAiailable() {
        return aiailable;
    }

    public void setAiailable(int aiailable) {
        this.aiailable = aiailable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    @Override
    public String toString() {
        return "MenuApp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pname='" + pname + '\'' +
                ", url='" + url + '\'' +
                ", aiailable=" + aiailable +
                ", pId=" + pId +
                '}';
    }
}

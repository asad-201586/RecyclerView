package com.asad.recyclerview;


public class GetData {
    private String city;
    private String des;
    private int img;


    public GetData(String city, String des, int img) {
        this.city = city;
        this.des = des;
        this.img = img;
    }

    public String getCity() {
        return city;
    }

    public String getDes() {
        return des;
    }

    public int getImg() {
        return img;
    }
}

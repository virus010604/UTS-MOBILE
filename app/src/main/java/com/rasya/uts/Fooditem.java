package com.rasya.uts;

public class Fooditem {
    private int imageResource;
    private String name;
    private String price;
    private String des;

    public Fooditem(int imageResource, String name, String price , String des) {
        this.imageResource = imageResource;
        this.name = name;
        this.price = price;
        this.des = des;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getDes() {
        return des;
    }
}

package com.cornez.shippingcalculator;

public class book {
    int Image;
    String Name;

    public book(int image,String name){
        Image=image;
        Name=name;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}

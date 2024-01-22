package com.cornez.shippingcalculator;

public class Gender {
    public String nowgender;
    public String passgender;
    public  Gender(){
        nowgender = "男性";
        passgender=nowgender;
    }
    public String getgender() {
        if(nowgender == "男性"){
            nowgender="女性";
        }
        else{
            nowgender="男性";
        }
        passgender=nowgender;
        return nowgender;
    }

    public String passgender() {

        return passgender;
    }


}

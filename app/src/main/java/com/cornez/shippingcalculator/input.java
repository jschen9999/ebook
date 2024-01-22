package com.cornez.shippingcalculator;

public class input
{
    public String nowinput;
    public String passinput;
    public Double calhei;
    public  input(){
        nowinput = "自行輸入";
        passinput=nowinput;
        calhei=0.0;
    }
    public String getinput() {
        if(nowinput == "自行輸入"){
            nowinput="估算身高";
        }
        else{
            nowinput="自行輸入";
        }
        passinput=nowinput;
        return nowinput;
    }

    public String passinput() {

        return passinput;
    }

    public Integer gethei(String g, double n, double o){
        if(g=="女性"){
            calhei=91.45 + (1.53 *n) - (0.16 *o);
            return Integer.valueOf(calhei.intValue());
        }
        else{
            calhei=85.1 + (1.73 *n) - (0.11 *o);
            return Integer.valueOf(calhei.intValue());
        }
    }
}


package com.cornez.shippingcalculator;

public class calcal {

    public double value;
    public calcal() {
        value=0.0;
    }

    public Double getwei(String g, int h) {
        if (g == "男性") {
            return (double)(Math.round(((h - 80) * 0.7)*10))/10;
        } else {
            return (double)(Math.round(((h - 70) * 0.6)*10))/10;
        }
    }

    public Double getneedcal(double w, int l, double a, double b, double c) {
        if (l == 1) {
            if (w < a) value= (double)(Math.round((35 * c)*10))/10;
            else if (w > b) value= (double)(Math.round((25 * c)*10))/10;
            else value= (double)(Math.round((30 * c)*10))/10;
        } else if (l == 2) {
            if (w < a) value= (double)(Math.round((40 * c)*10))/10;
            else if (w > b) value= (double)(Math.round((30 * c)*10))/10;
            else value= (double)(Math.round((35 * c)*10))/10;
        } else if (l == 3) {
            if (w < a) value=(double)(Math.round((45 * c)*10))/10;
            else if (w > b) value= (double)(Math.round((35 * c)*10))/10;
            else value=(double)(Math.round((40 * c)*10))/10;
        }
        return value;
    }
}

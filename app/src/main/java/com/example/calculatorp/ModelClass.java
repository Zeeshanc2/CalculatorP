package com.example.calculatorp;

public class ModelClass {
    private String calculate ="";
    private String date = "";
    private String result="";

    public ModelClass(){

    }

    public ModelClass(String calculate, String date,String result) {
        this.calculate = calculate;
        this.date = date;
        this.result=result;
    }

    public String getCalculate() {
        return calculate;
    }

    public String getDate() {
        return date;
    }

    public String getResult() {
        return result;
    }
}

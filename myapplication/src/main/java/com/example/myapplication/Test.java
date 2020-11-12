package com.example.myapplication;

public class Test {
    private String month;
    private String day;
    private String showText;

    public Test(String month, String day, String showText) {
        this.month = month;
        this.day = day;
        this.showText = showText;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getShowText() {
        return showText;
    }

    public void setShowText(String showText) {
        this.showText = showText;
    }
}

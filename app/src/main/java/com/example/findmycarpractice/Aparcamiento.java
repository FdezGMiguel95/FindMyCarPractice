package com.example.findmycarpractice;

public class Aparcamiento {
    private String name;
    private double aLat, aLong;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getaLat() {
        return aLat;
    }

    public void setaLat(double aLat) {
        this.aLat = aLat;
    }

    public double getaLong() {
        return aLong;
    }

    public void setaLong(double aLong) {
        this.aLong = aLong;
    }

    public Aparcamiento(String name, double aLat, double aLong) {
        this.name = name;
        this.aLat = aLat;
        this.aLong = aLong;
    }

    public Aparcamiento() {
    }
}
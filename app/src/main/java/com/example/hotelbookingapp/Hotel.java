package com.example.hotelbookingapp;

public class Hotel {
    private String nameofHotel;
    private double priceChargedPerNight;

    public Hotel(String mnameOfHotel,double mpriceChergedPeNight){
        this.nameofHotel=mnameOfHotel;
        this.priceChargedPerNight=mpriceChergedPeNight;

    }

    //getters
    public String getNameofHotel(){
        return nameofHotel;
    }

    public double getPriceChargedPerNight() {
        return priceChargedPerNight;
    }
}

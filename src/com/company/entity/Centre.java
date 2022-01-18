package com.company.entity;

public class Centre {

    private String id;
    private String city;
    private String address;


    public Centre(String id, String city, String address) {
        this.id = id;
        this.city = city;
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

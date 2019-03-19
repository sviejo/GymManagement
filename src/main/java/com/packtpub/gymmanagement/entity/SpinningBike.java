package com.packtpub.gymmanagement.entity;

public class SpinningBike {

    private int id, number, price;
    private String type;
    private boolean booked;

    public SpinningBike(int id, String type, int number, int price) {
        this(id, type, number, price, false);
    }

    private SpinningBike(int id, String type, int number, int price, boolean booked) {
        this.id = id;
        this.type = type;
        this.number = number;
        this.price = price;
        this.booked = booked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumber() { return number; }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPrice() {
        return  price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isBooked() { return booked; }

    public void setBooked(boolean booked) { this.booked = booked; }

    public SpinningBike getBookedSpinningBike() {
        return new SpinningBike(getId(), getType(), getNumber(), getPrice(), true);
    }
}

package com.packtpub.gymmanagement.entity;

public class Customer {

    private int id, tokens;
    private String name;

    public Customer(int id, String name){
        this.id = id;
        this.name = name;
        this.tokens = 50;
    }

    public int getId() { return id; }

    public String getName(){
        return name;
    }

    public int getTokens(){
        return tokens;
    }
}

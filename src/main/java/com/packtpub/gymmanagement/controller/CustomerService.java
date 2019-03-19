package com.packtpub.gymmanagement.controller;

import com.packtpub.gymmanagement.entity.Customer;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Logger;

@Named
@ViewScoped
public class CustomerService implements Serializable {

    @Inject
    private Logger logger;

    private String customerName;
    private int customerTokens;

    @PostConstruct
    public void createCustomer(){
        customerName = "John";
        customerTokens = 300;
        createCustomerList();
    }

    public String getCustomerName(){
        return customerName;
    }

    public int getCustomerTokens(){
        return customerTokens;
    }

    public void setCustomerTokens(int customerTokens) { this.customerTokens = customerTokens; }

    public ArrayList<Customer> createCustomerList(){
        ArrayList<Customer> customers = new ArrayList<Customer>();
        customers.add(new Customer(1,"Sergio"));
        customers.add(new Customer(2,"Antonio"));
        customers.add(new Customer(3,"Juan"));
        //log.info(String.format("%d customers added to the GYM", customers.size()));
        return customers;
    }
}

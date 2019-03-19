package com.packtpub.gymmanagement.entity;

//import com.packtpub.gymmanagement.control.SpinningBikeService;
import com.packtpub.gymmanagement.controller.CustomerService;
import com.packtpub.gymmanagement.exception.NoSuchSpinningBikeException;
import com.packtpub.gymmanagement.exception.SpinningBikeBookedException;

import javax.annotation.PostConstruct;
import javax.ejb.*;
import javax.inject.Inject;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static javax.ejb.LockType.READ;
import static javax.ejb.LockType.WRITE;

//@Singleton
//@Startup
//@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class Gym {

    //private SpinningBikeService spinningBikeService;

    private CustomerService customerService;

    private Map<Integer , SpinningBike> bikes;
    private ArrayList<Customer> customers;

    @PostConstruct
    public void setupGym() {
        //bikes = spinningBikeService.createSpinningBikeClass();
        //customers = customerService.createCustomerList();
    }

    @Lock(READ)
    public Collection<SpinningBike> getSpinningBikes(){
        return Collections.unmodifiableCollection(bikes.values());
    }

    @Lock(READ)
    public int getSpinningBikeNumber(int bikeId) throws NoSuchSpinningBikeException{
        return getSpinningBike(bikeId).getNumber();
    }

    @Lock(READ)
    public int getSpinningBikePrice(int bikeId) throws NoSuchSpinningBikeException{
        return getSpinningBike(bikeId).getPrice();
    }

    /*@Lock(WRITE)
    public synchronized void bookSpinningBike(int bikeId) throws SpinningBikeBookedException, NoSuchSpinningBikeException{
        final SpinningBike bike = getSpinningBike(bikeId);
        if(bike.isBooked()){
            throw new SpinningBikeBookedException(bikeId);
        }
        addSpinningBike(bike.getBookedSpinningBike());
    }*/

    @Lock(READ)
    private SpinningBike getSpinningBike(int bikeId) throws NoSuchSpinningBikeException {
        final SpinningBike bike = bikes.get(bikeId);
        if (bike == null)
        {
            throw new NoSuchSpinningBikeException(bikeId);
        }
        return bike;
    }

    @Lock(READ)
    private Customer getCurrentCustomer(String name) {
        return customers.stream().filter(customer -> customer.getName().equals(name)).findFirst().get();
    }
}

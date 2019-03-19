package com.packtpub.gymmanagement.controller;

import com.packtpub.gymmanagement.control.SpinningBikeService;
import com.packtpub.gymmanagement.entity.SpinningBike;
import com.packtpub.gymmanagement.enums.Enums;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;
import java.util.logging.Logger;

@Named
@ViewScoped
public class SpinningClassService implements Serializable {

    @Inject
    private Logger log;

    @Inject
    private CustomerService customer;

    @Inject
    private SpinningBikeService spinningBikeService;

    @Inject
    private FacesContext facesContext;

    private List<SpinningBike> spinningBikes;

    @PostConstruct
    public void createSpinningBikeClass() {
        setupSpinningBikeClass();
    }

    private void setupSpinningBikeClass() {
        spinningBikes = new ArrayList<SpinningBike>();
        HashMap<Enums.SpinningBikeTypes, Integer> classMap = new HashMap<Enums.SpinningBikeTypes, Integer>(){};

        classMap.put(Enums.SpinningBikeTypes.UPRIGHT, 2);
        classMap.put(Enums.SpinningBikeTypes.RECUMBENT, 4);
        classMap.put(Enums.SpinningBikeTypes.DUAL_ACTION, 2);

        spinningBikes = spinningBikeService.addSpinninBikes2Class(classMap);

        log.info(String.format("Spinning bike list constructed (%d Spinning bikes added).", spinningBikes.size()));
    }

    public int getSpinningBikesNumber() {
        return spinningBikes.size();
    }

    public int getSpinningBikesBooked() {
        return ((int) spinningBikes.stream().filter(s -> s.isBooked()).count());
    }

    public int getSpinningBikesAvailable() {
        return getSpinningBikesNumber() - getSpinningBikesBooked();
    }

    public List<SpinningBike> getSpinningBikes() {
        return spinningBikes;
    }

    public void bookSpinningBike(long spinninBikeId, int price) {
        log.info("Booking seat " + spinninBikeId);

        int currentTokens = customer.getCustomerTokens();

        if (price > currentTokens) {
            final FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Not enough Money!",
                    "Registration failed");
            facesContext.addMessage(null, m);
            return;
        }

        bookSpinningBike(spinninBikeId);

        final FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
        facesContext.addMessage(null, m);
        log.info("Seat booked.");

        customer.setCustomerTokens(currentTokens - price);
    }

    private void bookSpinningBike(long spinninBikeId) {
        for(SpinningBike spinningBike : spinningBikes) {
            if(spinningBike.getId() == spinninBikeId) {
                spinningBike.setBooked(true);
            }
        }
    }
}
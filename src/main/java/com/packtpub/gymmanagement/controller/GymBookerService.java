package com.packtpub.gymmanagement.controller;

import com.packtpub.gymmanagement.exception.NoSuchSpinningBikeException;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.logging.Logger;

@Named
@Model
@SessionScoped
public class GymBookerService implements Serializable {


    @Inject
    private FacesContext facesContext;

    private int tokens;

    @PostConstruct
    public void createCustomer(){
        //logger.info("Setting tokens up");
        this.tokens = 100;
    }

    /*public void bookSpinningBike(int spinningBikeId){
        try{
            logger.info("Booking spinning bike: " + spinningBikeId);
            int spinningBikePrice = gym.getSpinningBikePrice(spinningBikeId);

            if(spinningBikePrice > tokens){
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Not enough Tokens!", "Booking unsuccessful");
                facesContext.addMessage(null, message);
                return;
            }

            gym.bookSpinningBike(spinningBikeId);

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Spinning bike booked!", "Booking successful");
            facesContext.addMessage(null, message);
            logger.info(String.format("Spinning bike {0} booked.", spinningBikeId));

            tokens = tokens - spinningBikePrice;
        }catch (Exception exception){}
    }*/

    public int getTokens(){
        return tokens;
    }
}

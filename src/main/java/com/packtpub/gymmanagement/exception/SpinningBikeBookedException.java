package com.packtpub.gymmanagement.exception;

import java.io.*;

public class SpinningBikeBookedException extends Exception {

    private int bikeId;

    public SpinningBikeBookedException(int bikeId)
    {
        this.bikeId = bikeId;
    }

    public String getBikeId()
    {
        return "Spinning bike " + bikeId + " already booked!";
    }
}

package com.packtpub.gymmanagement.exception;

import java.io.*;

public class NoSuchSpinningBikeException extends Exception {

    private int bikeId;

    public NoSuchSpinningBikeException(int bikeId)
    {
        this.bikeId = bikeId;
    }

    public String getBikeId()
    {
        return "Spinning bike " + bikeId + " does not exist!";
    }
}

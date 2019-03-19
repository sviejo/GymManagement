package com.packtpub.gymmanagement.controller;

import com.packtpub.gymmanagement.entity.SpinningBike;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class Hello implements Serializable {

    @Inject
    private Logger log;

    private List<SpinningBike> userList;

    @PostConstruct
    private void init() {
        userList = new ArrayList<>();
        int id = 0;
        userList.add(new SpinningBike(++id, "Dual-action", 2, 40));
        userList.add(new SpinningBike(++id, "Dual-action", 2, 40));
        userList.add(new SpinningBike(++id, "Dual-action", 2, 40));
        userList.add(new SpinningBike(++id, "Dual-action", 2, 40));

        log.info(String.format("User list constructed (%d Users added).", userList.size()));
    }

    public List<SpinningBike> getUserList() {
        return userList;
    }

    public int getUserCount() {
        return userList.size();
    }

}
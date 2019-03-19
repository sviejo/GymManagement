package com.packtpub.gymmanagement.control;

import com.packtpub.gymmanagement.entity.SpinningBike;
import com.packtpub.gymmanagement.enums.Enums;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.*;
import java.util.logging.Logger;

@Stateless
public class SpinningBikeService {

    @Inject
    private Logger log;

    public ArrayList<SpinningBike> addSpinninBikes2Class(HashMap<Enums.SpinningBikeTypes, Integer> classMap) {
        ArrayList<SpinningBike> spinningBikes = new ArrayList<SpinningBike>();
        int id = 0;
        Random random = new Random();

        Iterator iterator = classMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry)iterator.next();
            switch((Enums.SpinningBikeTypes) pair.getKey())
            {
                case UPRIGHT:
                    log.info(String.format("About to add %s spinning bikes [%s] to current class", pair.getValue().toString(), pair.getKey().toString()));
                    for(int i = 0; i < (int)pair.getValue(); i++)
                        spinningBikes.add(new SpinningBike(++id, "Upright", random.nextInt(10000), 30));
                    log.info(String.format("%s spinning bikes [%s] added to current class", pair.getValue().toString(), pair.getKey().toString()));
                    break;
                case RECUMBENT:
                    log.info(String.format("About to add %s spinning bikes [%s] to current class", pair.getValue().toString(), pair.getKey().toString()));
                    for(int i = 0; i < (int)pair.getValue(); i++)
                        spinningBikes.add(new SpinningBike(++id, "Recumbent", random.nextInt(10000), 20));
                    log.info(String.format("%s spinning bikes [%s] added to current class", pair.getValue().toString(), pair.getKey().toString()));
                    break;
                case DUAL_ACTION:
                    log.info(String.format("About to add %s spinning bikes [%s] to current class", pair.getValue().toString(), pair.getKey().toString()));
                    for(int i = 0; i < (int)pair.getValue(); i++)
                        spinningBikes.add(new SpinningBike(++id, "Dual-action", random.nextInt(10000), 40));
                    log.info(String.format("%s spinning bikes [%s] added to current class", pair.getValue().toString(), pair.getKey().toString()));
                    break;
            }
            iterator.remove(); // avoids a ConcurrentModificationException
        }
        return spinningBikes;
    }

    public void bookSpinningBike(long spinningBikeId) {
        //spinningBike
    }
}

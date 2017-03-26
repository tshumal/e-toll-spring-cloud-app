package io.linx.etoll.service;

import io.linx.etoll.model.DriverContactDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by lingani on 3/25/17.
 */
@Service
@Slf4j
public class ContactService {

    public DriverContactDetails getCustomerContactDetails(Integer driverId) throws InterruptedException {

        //add arbitrary latency
        Random r = new Random();
        int multiplier = r.nextInt(5) * 1000;
        log.info("multiplier: " + multiplier);
        Thread.sleep(multiplier);


        HashMap<Integer, DriverContactDetails> customers = new HashMap<>();
        customers.put(100, new DriverContactDetails(100, "Beverly Goldberg"));
        customers.put(101, new DriverContactDetails(101, "Dave Kim"));
        customers.put(102, new DriverContactDetails(102, "Lainey Lewis"));

        return customers.get(driverId);
    }
}

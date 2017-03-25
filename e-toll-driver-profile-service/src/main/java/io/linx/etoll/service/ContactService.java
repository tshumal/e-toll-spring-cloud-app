package io.linx.etoll.service;

import io.linx.etoll.model.DriverContactDetails;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

/**
 * Created by lingani on 3/25/17.
 */
@RestController
@Slf4j
public class ContactService {

    public DriverContactDetails getCustomerContactDetails(@PathVariable Integer driverId) throws InterruptedException {

        //add arbitrary latency
        Random r = new Random();
        int multiplier = r.nextInt(5) * 1000;
        log.info("multiplier: " + multiplier);
        Thread.sleep(multiplier);


        List<DriverContactDetails> customers = new ArrayList<>();
        customers.add(new DriverContactDetails(100, "Beverly Goldberg"));
        customers.add(new DriverContactDetails(101, "Dave Kim"));
        customers.add(new DriverContactDetails(102, "Lainey Lewis"));

        DriverContactDetails result = customers.get(driverId);

        return result;
    }
}

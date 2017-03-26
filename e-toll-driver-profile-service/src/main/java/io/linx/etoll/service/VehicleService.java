package io.linx.etoll.service;

import io.linx.etoll.model.DriverVehicleDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created by lingani on 3/25/17.
 */
@Service
public class VehicleService {

    @Autowired
    private Tracer tracer;

    public DriverVehicleDetails getCustomerVehicleDetails(Integer driverId) throws InterruptedException {

        DriverVehicleDetails driverVehicleDetails;

        Span s = this.tracer.createSpan("lookupvehicle");
        try {
            //add tags
            this.tracer.addTag("customerid", driverId.toString());

            s.logEvent("DB query started");

            Thread.sleep(500);

            HashMap<Integer, DriverVehicleDetails> vehicles = new HashMap<>();
            vehicles.put(100, new DriverVehicleDetails(100, "Lincoln Continental", "SNU 330 GP"));
            vehicles.put(101, new DriverVehicleDetails(101, "Chevrolet Camaro", "R7T YR43 GP"));
            vehicles.put(102, new DriverVehicleDetails(102, "Volkswagen Beetle", "6CV I3E2 GP"));

            driverVehicleDetails = vehicles.get(driverId);

            s.logEvent("DB query completed");
        } finally {
            this.tracer.close(s);
        }

        return driverVehicleDetails;
    }
}

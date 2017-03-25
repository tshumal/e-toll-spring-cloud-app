package io.linx.etoll.controller;

import io.linx.etoll.model.DriverVehicleDetails;
import io.linx.etoll.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lingani on 3/25/17.
 */
@RestController
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @RequestMapping(value="/driver/{driverId}/vehicledetails", method= RequestMethod.GET)
    public DriverVehicleDetails getCustomerVehicleDetails(@PathVariable Integer driverId)  throws InterruptedException {

        return vehicleService.getCustomerVehicleDetails(driverId);
    }
}

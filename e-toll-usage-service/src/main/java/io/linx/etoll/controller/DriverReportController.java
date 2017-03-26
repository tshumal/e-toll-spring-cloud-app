package io.linx.etoll.controller;

import io.linx.etoll.model.Driver;
import io.linx.etoll.model.DriverContactDetails;
import io.linx.etoll.model.DriverVehicleDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lingani on 3/26/17.
 */
@RestController
@Slf4j
public class DriverReportController {

    @Autowired
    OAuth2RestTemplate oAuth2RestTemplate;


    @RequestMapping(value = "/driver/{driverId}", method = RequestMethod.GET)
    public Driver getDriver(@PathVariable Integer driverId) {

        String token =  oAuth2RestTemplate.getAccessToken().toString();

        log.info("Token: " + token);

        DriverContactDetails contact = oAuth2RestTemplate.getForObject("http://localhost:8003/driver/" + driverId + "/contactdetails", DriverContactDetails.class);
        DriverVehicleDetails vehicle = oAuth2RestTemplate.getForObject("http://localhost:8003/driver/" + driverId + "/vehicledetails", DriverVehicleDetails.class);

        return new Driver(driverId, vehicle.getVehicleMake(), vehicle.getPlateNumber(), contact.getAddress());
    }
}

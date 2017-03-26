package io.linx.etoll.controller;

import io.linx.etoll.model.Driver;
import io.linx.etoll.model.DriverContactDetails;
import io.linx.etoll.model.DriverVehicleDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
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

    @RequestMapping(value = "/driver/{driverId}", method = RequestMethod.GET)
    public Driver getDriver(@PathVariable Integer driverId) {

        ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
        resourceDetails.setClientAuthenticationScheme(AuthenticationScheme.header);
        resourceDetails.setAccessTokenUri("http://localhost:9000/uaa/oauth/token");

        //must be a valid scope or get an error; if empty, get all scopes (default); better to ask for one
        //resourceDetails.setScope(Arrays.asList("toll_read"));

        //must be valid client id or get an error
        resourceDetails.setClientId("linx");
        resourceDetails.setClientSecret("linxsecret");

        //diff user results in diff authorities/roles coming out; preauth on roles fails for adam, works for barry
        resourceDetails.setUsername("lingani");
        resourceDetails.setPassword("password");

        OAuth2RestTemplate oAuth2RestTemplate = new OAuth2RestTemplate(resourceDetails);
        //could also get scopes: template.getAccessToken().getScope()
        String token =  oAuth2RestTemplate.getAccessToken().toString();//.getValue();

        log.info("Token: " + token);

        DriverContactDetails contact = oAuth2RestTemplate.getForObject("http://localhost:8003/driver/" + driverId + "/contactdetails", DriverContactDetails.class);
        DriverVehicleDetails vehicle = oAuth2RestTemplate.getForObject("http://localhost:8003/driver/" + driverId + "/vehicledetails", DriverVehicleDetails.class);

        return new Driver(driverId, vehicle.getVehicleMake(), vehicle.getPlateNumber(), contact.getAddress());
    }
}

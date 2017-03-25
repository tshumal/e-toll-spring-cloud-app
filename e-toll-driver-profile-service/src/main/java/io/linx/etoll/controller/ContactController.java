package io.linx.etoll.controller;

import io.linx.etoll.model.DriverContactDetails;
import io.linx.etoll.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lingani on 3/25/17.
 */
@RestController
public class ContactController {

    @Autowired
    ContactService contactService;

    @RequestMapping(value = "/driver/{driverId}/contactdetails", method = RequestMethod.GET)
    public
    @ResponseBody
    DriverContactDetails getCustomerContactDetails(@PathVariable Integer driverId) throws InterruptedException {

        return contactService.getCustomerContactDetails(driverId);
    }
}

package io.linx.etoll.controller;

import io.linx.etoll.model.ETollUsage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by lingani on 2017/03/13.
 */
@RestController
public class UsageReportController {

    @RequestMapping(value = "/tolldata", method = RequestMethod.GET)
    public ArrayList<ETollUsage> getTollData(){

        ETollUsage instance1 = new ETollUsage("100", "n1-toll-plazza", "DT82NZGP", "2016-09-30T06:31:22");
        ETollUsage instance2 = new ETollUsage("101", "mafokong-toll-plazza", "DZ99ZWGP", "2016-09-30T06:32:50");
        ETollUsage instance3 = new ETollUsage("102", "n12-south-toll-plazza", "DNTTRYM3GP", "2016-09-30T06:37:01");

		ArrayList<ETollUsage> tolls = new ArrayList<>();
		tolls.add(instance1);
		tolls.add(instance2);
		tolls.add(instance3);

		return tolls;

    }



}

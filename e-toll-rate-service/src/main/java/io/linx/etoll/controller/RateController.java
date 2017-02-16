package io.linx.etoll.controller;

import io.linx.etoll.model.Rate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lingani on 2017/02/15.
 */
@RestController
public class RateController {

    @Value("${rate}")
    private String rate;

    @Value("${lanecount}")
    private String laneCount;

    @Value("${tollstart}")
    private String tollStart;


    @RequestMapping(value = "/rate", method = RequestMethod.GET)
    public Rate getRate(Model m){

        Rate tollRate = new Rate();
        tollRate.setLanecount(laneCount);
        tollRate.setTollstart(tollStart);
        tollRate.setRate(rate);

        return tollRate;
    }
}

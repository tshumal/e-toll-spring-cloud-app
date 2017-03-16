package io.linx.etoll.controller;

import io.linx.etoll.model.Rate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lingani on 2017/02/15.
 */
@RestController
@RefreshScope
@EnableResourceServer
public class RateController {

    @Value("${rate}")
    private String rate;

    @Value("${lanecount}")
    private String laneCount;

    @Value("${tollstart}")
    private String tollStart;

    @Value("${connstring}")
    private String connstring;


    @RequestMapping(value = "/rate", method = RequestMethod.GET)
    public Rate getRate(Model m){

        Rate tollRate = new Rate();
        tollRate.setLanecount(laneCount);
        tollRate.setTollstart(tollStart);
        tollRate.setRate(rate);
        tollRate.setConnstring(connstring);

        return tollRate;
    }
}

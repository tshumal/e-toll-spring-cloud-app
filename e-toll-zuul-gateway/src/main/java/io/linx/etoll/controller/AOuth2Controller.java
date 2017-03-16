package io.linx.etoll.controller;


import io.linx.etoll.model.ETollUsage;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

/**
 * Created by lingani on 2017/03/14.
 */
@Controller
@EnableOAuth2Sso
@Log
public class AOuth2Controller extends WebSecurityConfigurerAdapter {

    @Autowired
    private OAuth2ClientContext clientContext;

    @Autowired
    private OAuth2RestTemplate oauth2RestTemplate;

    private static String SERVICE_URI = "http://localhost:8002/tolldata";

    @RequestMapping("/")
    public String loadHome() {

        return "home";
    }

    @RequestMapping("/reports")
    public String loadReports(Model model) {

        ResponseEntity<ArrayList<ETollUsage>> tolls = oauth2RestTemplate.
                exchange(SERVICE_URI, HttpMethod.GET, null, new ParameterizedTypeReference<ArrayList<ETollUsage>>(){});

        model.addAttribute("tolls", tolls.getBody());

        OAuth2AccessToken oAuth2AccessToken = clientContext.getAccessToken();
        log.info("Token : " + oAuth2AccessToken.getValue());

        return "reports";
    }

    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest()
                .authenticated();

        // .antMatchers("/", "/login**")
        //        .permitAll()
    }*/
}

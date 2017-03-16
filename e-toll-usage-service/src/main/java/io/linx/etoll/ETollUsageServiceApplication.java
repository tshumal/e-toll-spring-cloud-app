package io.linx.etoll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * Created by lingani on 2017/02/15.
 */
@SpringBootApplication
@EnableResourceServer
public class ETollUsageServiceApplication {

    public static void main(String args[]) {
        SpringApplication.run(ETollUsageServiceApplication.class);
    }
}

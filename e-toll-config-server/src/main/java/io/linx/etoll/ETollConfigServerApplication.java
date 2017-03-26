package io.linx.etoll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by lingani on 2017/01/01.
 */
@SpringBootApplication
@EnableConfigServer
public class ETollConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ETollConfigServerApplication.class, args);
    }
}

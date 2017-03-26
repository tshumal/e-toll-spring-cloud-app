package io.linx.etoll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

/**
 * Created by lingani on 3/26/17.
 */
@SpringBootApplication
@EnableZipkinServer
public class ETollZipkinServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ETollZipkinServerApplication.class, args);
    }
}

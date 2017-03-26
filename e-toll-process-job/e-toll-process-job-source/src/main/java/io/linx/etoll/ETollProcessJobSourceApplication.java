package io.linx.etoll;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

/**
 * Created by lingani on 2017/03/11.
 */
@SpringBootApplication
@Log
@EnableBinding(Source.class)
public class ETollProcessJobSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ETollProcessJobSourceApplication.class, args);
    }

}

package io.linx.etoll;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

/**
 * Created by lingani on 2017/02/17.
 */
@SpringBootApplication
@EnableTask
@Log
public class ETollProcessJobTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(ETollProcessJobTaskApplication.class, args);
    }

    @Bean
    public ETollProcessTask tollProcessTask(){
        return new ETollProcessTask();
    }

    public class ETollProcessTask implements CommandLineRunner {

        @Override
        public void run(String... strings) throws Exception {

            //parameters stationid, license plate, timestamp
            if(null != strings){

                log.info("Parameter length is " + strings.length);

                if(strings.length > 0){
                    String stationId = strings[0];
                    String licensePlate = strings[1];
                    String timestamp = strings[2];

                    log.info("Station Id is " + stationId + " plate is " + licensePlate + ", timestamp is " + timestamp);
                }
            }
            log.info("Task completed");
        }
    }
}

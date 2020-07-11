package com.cha.edu.shiftenquiryservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan("com.cha.edu.shiftenquiryservice.entity")
@ComponentScan({"com.cha.edu.shiftenquiryservice"})
@EnableJpaRepositories("com.cha.edu.shiftenquiryservice.repository")
public class ShiftEnquiryServiceApplication {
    private static final Logger logger = LoggerFactory.getLogger(ShiftEnquiryServiceApplication.class);

    public static void main(String[] args) {
        logger.info("Starting shift enquiry service");
        SpringApplication.run(ShiftEnquiryServiceApplication.class, args);
    }

}

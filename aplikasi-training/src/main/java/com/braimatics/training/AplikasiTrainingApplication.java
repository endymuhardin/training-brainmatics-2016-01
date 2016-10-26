package com.braimatics.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@EntityScan(
        basePackageClasses = {AplikasiTrainingApplication.class, Jsr310JpaConverters.class}
)
@SpringBootApplication
public class AplikasiTrainingApplication {

    public static void main(String[] args) {
        SpringApplication.run(AplikasiTrainingApplication.class, args);
    }
}

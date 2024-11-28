package com.springboot.udemycourse.config;

import com.springboot.udemycourse.common.Coach;
import com.springboot.udemycourse.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}

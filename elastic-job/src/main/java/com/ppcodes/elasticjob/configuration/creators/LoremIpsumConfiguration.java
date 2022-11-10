package com.ppcodes.elasticjob.configuration.creators;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoremIpsumConfiguration {

    @Bean
    public Lorem initloremIpsum() {
        return LoremIpsum.getInstance();
    }



}

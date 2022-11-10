package com.ppcodes.elasticjob.configuration.creators;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class JobCreatorConfiguration {
    @Value("${creator.job.title.length.min}")
    private int TITLE_LENGTH_MIN;
    @Value("${creator.job.title.length.max}")
    private int TITLE_LENGTH_MAX;
    @Value("${creator.job.description.length.min}")
    private int DESCRIPTION_LENGTH_MIN;
    @Value("${creator.job.description.length.max}")
    private int DESCRIPTION_LENGTH_MAX;

    @Value("${creator.job.count}")
    public int COUNT;

}

package com.ppcodes.elasticjob.persistence.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Document(indexName = "job")
public class JobInformation {

    @Id
    private String id;
    private String title;
    private String description;
    private String source;

}

package com.ppcodes.elasticjob.persistence.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Builder
@Document(indexName = "job")
@ToString
@JsonSerialize
@Data
public class JobInformation {

    @Id
    private String id;
    @Field
    private String title;
    @Field
    private String description;
    @Field
    private String technologyTag;
    @Field
    private String source;

}

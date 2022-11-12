package com.ppcodes.elasticjob.persistence.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Collections;
import java.util.Set;

@Document(indexName = "job")
@ToString
@JsonSerialize
@Data
@Builder
public class JobInformation {

    @Id
    private String id;
    @Field(type = FieldType.Text)
    private String title;
    @Field(type = FieldType.Text)
    private String description;
    @Builder.Default
    @Field(type = FieldType.Text)
    private Set<String> technologyTags = Collections.emptySet();
    @Field
    private String source;

}

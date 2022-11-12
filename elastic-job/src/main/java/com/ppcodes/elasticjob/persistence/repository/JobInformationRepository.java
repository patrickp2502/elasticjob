package com.ppcodes.elasticjob.persistence.repository;

import com.ppcodes.elasticjob.persistence.model.JobInformation;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.stream.Stream;

public interface JobInformationRepository extends ElasticsearchRepository<JobInformation, String> {

    List<JobInformation> getAllByDescriptionContaining(String key);

    @Query("{\"match\": {\"description\": \"?0\"}}")
    Stream<JobInformation> getAllByDescriptionMatchingWord(String word);



}

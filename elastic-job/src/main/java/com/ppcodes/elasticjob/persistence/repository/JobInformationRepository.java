package com.ppcodes.elasticjob.persistence.repository;

import com.ppcodes.elasticjob.persistence.model.JobInformation;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface JobInformationRepository extends ElasticsearchRepository<JobInformation, String> {

    List<JobInformation> getAllByDescriptionContaining(String key);


}

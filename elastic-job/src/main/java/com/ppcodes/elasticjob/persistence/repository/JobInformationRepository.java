package com.ppcodes.elasticjob.persistence.repository;

import com.ppcodes.elasticjob.persistence.model.JobInformation;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface JobInformationRepository extends ElasticsearchRepository<JobInformation, String> {



}

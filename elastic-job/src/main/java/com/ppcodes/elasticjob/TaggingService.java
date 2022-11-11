package com.ppcodes.elasticjob;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import com.ppcodes.elasticjob.persistence.repository.JobInformationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaggingService {

    private final List<String> TAGS = List.of(
            "java",
            "javascript",
            "nosql",
            "sql",
            "elasticsearch");

    private final JobInformationRepository jobInformationRepository;



    public void runTaggingProcess() {
        TAGS.forEach(tag -> tag(tag) );
    }

    private void tag(String tag) {
        //jobInformationRepository.getAllByTag(tag).forEach(jobInformation -> log.info(jobInformation.toString()));
        jobInformationRepository.getAllByTagButTest(tag);

    }



}

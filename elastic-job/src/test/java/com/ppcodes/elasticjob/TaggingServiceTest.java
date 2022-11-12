package com.ppcodes.elasticjob;

import com.ppcodes.elasticjob.persistence.model.JobInformation;
import com.ppcodes.elasticjob.persistence.repository.JobInformationRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@Slf4j
class TaggingServiceTest {

    @Autowired
    TaggingService taggingService;

    @Autowired
    JobInformationRepository repository;

    @Test
    void runProcess() {
        taggingService.runTaggingProcess();
    }


    @Test
    void testRepository() {
        System.out.println("test");
        List<JobInformation> repositoryMethodResult = repository.getAllByDescriptionContaining("java");

    }
}
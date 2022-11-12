package com.ppcodes.elasticjob;

import com.ppcodes.elasticjob.persistence.model.JobInformation;
import com.ppcodes.elasticjob.persistence.repository.JobInformationRepository;
import com.ppcodes.elasticjob.service.TaggingService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
@Slf4j
class TaggingServiceTest {

    @MockBean
    JobInformationRepository repository;

    @InjectMocks
    @Autowired
    TaggingService taggingService;


    static Stream<Arguments> streamArguments() {
        return Stream.of(
                Arguments.of("java", Stream.of(
                        JobInformation.builder()
                                .id("java")
                                .description("this is java tag")
                                .technologyTags(Collections.emptySet())
                                .build())
                ),
                Arguments.of(
                        "javascript", Stream.of(
                                JobInformation.builder()
                                        .id("javascript")
                                        .description("this is javascript tag")
                                        .technologyTags(Collections.emptySet())
                                        .build()
                        )),
                Arguments.of(
                        "docker", Stream.of(
                                JobInformation.builder()
                                        .id("docker")
                                        .description("this is docker tag")
                                        .technologyTags(Collections.emptySet())
                                        .build())));


    }


    @MethodSource("streamArguments")
    @ParameterizedTest
    void runProcess(String tag, Stream<JobInformation> hits) {

        Mockito.when(repository.getAllByDescriptionMatchingWord(tag)).thenReturn(hits);
        taggingService.runTaggingProcess();


    }

}
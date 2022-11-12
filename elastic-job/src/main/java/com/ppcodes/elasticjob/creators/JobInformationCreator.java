package com.ppcodes.elasticjob.creators;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.ExistsRequest;
import com.ppcodes.elasticjob.configuration.creators.JobCreatorConfiguration;
import com.ppcodes.elasticjob.persistence.model.JobInformation;
import com.ppcodes.elasticjob.persistence.repository.JobInformationRepository;
import com.thedeanda.lorem.Lorem;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;


@Service
@Slf4j
@RequiredArgsConstructor
public class JobInformationCreator {


    private final JobCreatorConfiguration configuration;
    private final JobInformationRepository jobInformationRepository;
    private final Lorem lorem;

    private static final List<String> SPECIAL_WORDS = List.of(
            "java",
            "javascript",
            "html",
            "pega",
            "docker"
    );

    @PostConstruct
    public void create() {
        Set<JobInformation> dataSet = new HashSet<>();
        for (int i = 0; i < configuration.getCOUNT(); i++) {
            JobInformation newInformation = createJobInformation();
            dataSet.add(newInformation);
        }
        log.info(dataSet.size() + " numbers of job information created");
        jobInformationRepository.saveAll(dataSet);

    }

    private String getRandomSpecialWord() {
        int size = SPECIAL_WORDS.size();
        Random random = new Random();
        int weight = random.nextInt(100);
        int weightLimit = 0;
        if (weight > weightLimit) {
            return "";
        }
        int index = random.nextInt(size);
        return SPECIAL_WORDS.get(index);

    }


    private JobInformation createJobInformation() {
        return JobInformation.builder()
                .title(createTitle())
                .description(createDescription())
                .build();
    }

    private String createTitle() {
        return lorem.getTitle(
                configuration.getTITLE_LENGTH_MIN(),
                configuration.getTITLE_LENGTH_MAX()
        );
    }

    private String createDescription() {
        return lorem.getWords(
                configuration.getDESCRIPTION_LENGTH_MIN(),
                configuration.getDESCRIPTION_LENGTH_MAX()
        ) + " " + getRandomSpecialWord();
    }


}

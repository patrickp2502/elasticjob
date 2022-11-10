package com.ppcodes.elasticjob.creators;

import com.ppcodes.elasticjob.configuration.creators.JobCreatorConfiguration;
import com.ppcodes.elasticjob.persistence.model.JobInformation;
import com.ppcodes.elasticjob.persistence.repository.JobInformationRepository;
import com.thedeanda.lorem.Lorem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;


@Service
@Slf4j
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

    public JobInformationCreator(JobCreatorConfiguration configuration, JobInformationRepository jobInformationRepository, Lorem lorem) {
        this.configuration = configuration;
        this.jobInformationRepository = jobInformationRepository;
        this.lorem = lorem;
        create(configuration.getCOUNT());
    }


    public void create(int count) {
        Set<JobInformation> dataSet = new HashSet<>();
        for (int i = 0; i < count; i++) {
            JobInformation newInformation = createJobInformation();
            dataSet.add(newInformation);
        }
        log.info(dataSet.size()+" numbers of job information created");
        jobInformationRepository.saveAll(dataSet);

    }

    private String getRandomSpecialWord() {
        int size = SPECIAL_WORDS.size();
        Random random = new Random();
        int weight = random.nextInt(100);
        int weightLimit = 20;
        if (weight > 20) {
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
        )+ getRandomSpecialWord();
    }


}

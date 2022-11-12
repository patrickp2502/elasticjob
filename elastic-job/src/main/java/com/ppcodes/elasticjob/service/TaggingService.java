package com.ppcodes.elasticjob.service;

import com.ppcodes.elasticjob.configuration.creators.JobCreatorConfiguration;
import com.ppcodes.elasticjob.persistence.repository.JobInformationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaggingService {


    private final JobCreatorConfiguration jobCreatorConfiguration;
    private final JobInformationRepository jobInformationRepository;

    public void runTaggingProcess() {
        jobCreatorConfiguration.getTAGS().forEach(this::tag);
    }

    private void tag(String tag) {
        jobInformationRepository.getAllByDescriptionMatchingWord(tag)
                .peek(jobInformation -> jobInformation.getTechnologyTags().add(tag))
                .forEach(jobInformationRepository::save);
    }


}

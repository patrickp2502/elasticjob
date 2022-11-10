package com.ppcodes.elasticjob.persistence.controller;

import com.ppcodes.elasticjob.persistence.model.JobInformation;
import com.ppcodes.elasticjob.persistence.repository.JobInformationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jobs")
@RequiredArgsConstructor
@Slf4j
class JobInformationController {

    private final JobInformationRepository repository;

    @GetMapping
    public List<JobInformation> getAllJobInformation(@RequestParam("key") String key) {
        log.info(key);

        List<JobInformation> result = repository.getAllByDescriptionContaining(key);
        log.info(String.valueOf(result.size()));
        return result;
    }

    @GetMapping("/test")
    public String getTest() {
        return "test";
    }


}

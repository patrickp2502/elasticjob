package com.ppcodes.elasticjob.persistence.controller;

import com.ppcodes.elasticjob.persistence.model.JobInformation;
import com.ppcodes.elasticjob.persistence.repository.JobInformationRepository;
import com.ppcodes.elasticjob.service.TaggingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/jobs")
@RequiredArgsConstructor
@Slf4j
class JobInformationController {

    private final JobInformationRepository repository;
    private final TaggingService taggingService;

    @GetMapping
    public Page<JobInformation> getAllJobInformation() {
        Pageable pageable = PageRequest.of(0, 100);
        return repository.findAll(pageable);
    }

    @GetMapping("/tag")
    public void getTest() {
        taggingService.runTaggingProcess();

    }



}

package com.ppcodes.elasticjob.persistence.controller;

import com.ppcodes.elasticjob.persistence.model.JobInformation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jobs")
public class JobInformationController {

    @GetMapping
    public ResponseEntity<List<JobInformation>> getAllJobInformation() {

        return ResponseEntity.ok(List.of(new JobInformation()));
    }



}

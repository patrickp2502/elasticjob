package com.ppcodes.elasticjob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories
public class ElasticJobApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElasticJobApplication.class, args);
	}

}

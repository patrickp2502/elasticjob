package com.ppcodes.elasticjob.configuration.creators;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;

/*@Configuration*/
public class ElasticConfiguration {

    @Bean
    public RestClient getHttpClient() {
        return RestClient.builder(
                new HttpHost("localhost", 9200)
        ).build();
    }

    @Bean
    ElasticsearchTransport getTransport(RestClient restClient) {
        return new RestClientTransport(
                restClient, new JacksonJsonpMapper()
        );
    }

    @Bean
    ElasticsearchClient getClient(ElasticsearchTransport transport) {
        return new ElasticsearchClient(transport);
    }

}

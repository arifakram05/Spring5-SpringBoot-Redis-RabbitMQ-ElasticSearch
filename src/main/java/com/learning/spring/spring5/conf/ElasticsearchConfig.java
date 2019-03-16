package com.learning.spring.spring5.conf;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
@EnableElasticsearchRepositories(basePackages = { "com.learning.spring.spring5.dao" })
public class ElasticsearchConfig {

    private static final String ES_HOST = "127.0.0.1";
    private static final int ES_PORT = 9300;

    @Bean
    public Client getElasticsearchClient() throws UnknownHostException {
        return new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new TransportAddress(InetAddress.getByName(ES_HOST), ES_PORT));
    }

    @Bean
    public ElasticsearchOperations getElasticsearchTemplate() throws UnknownHostException {
        return new ElasticsearchTemplate(getElasticsearchClient());
    }
}

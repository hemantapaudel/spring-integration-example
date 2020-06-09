package com.account.service.client;

import com.account.service.model.StatementResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
public class StatementClient {


    private static final String GET_STATEMENT_BY_ACCOUNT = "statementservice/statement";


    @Value("${statement.host}")
    private String statementHost;

    @Value("${statement.port}")
    private String statementPort;

    public Mono<StatementResponse> getStatement(String accountNumber) {
        URI uri = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host(statementHost)
                .port(statementPort)
                .path(GET_STATEMENT_BY_ACCOUNT)
                .queryParam("id", accountNumber)
                .build()
                .toUri();

        Mono<StatementResponse> statementResponseMono = WebClient.create()
                .get()
                .uri(uri)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(StatementResponse.class);


        return statementResponseMono;
    }


}

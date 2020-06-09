package com.account.service.client;

import com.account.service.model.Transaction;
import com.account.service.model.TransactionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class TransactionClient {

    private static final String GET_TRANSACTION_BY_ACCOUNT = "transactionservice/transaction";


    private Logger LOGGER = LoggerFactory.getLogger(TransactionClient.class);


    private RestTemplate restTemplate = new RestTemplate();

    @Value("${transaction.host}")
    private String transactionHost;

    @Value("${transaction.port}")
    private String transactionPort;


    public List<Transaction> getTransaction(String accountNumber) {

        try {
            URI uri = UriComponentsBuilder.newInstance()
                    .scheme("http")
                    .host(transactionHost)
                    .port(transactionPort)
                    .path(GET_TRANSACTION_BY_ACCOUNT)
                    .queryParam("id", accountNumber)
                    .build()
                    .toUri();

            LOGGER.info("fetching transactions for account number {}", accountNumber);
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity entity = new HttpEntity<>(headers);
            ResponseEntity<TransactionResponse> transactionResponse = restTemplate.exchange(uri, HttpMethod.GET, entity, TransactionResponse.class);
            if (transactionResponse.getStatusCode().equals(HttpStatus.OK)) {
                TransactionResponse transactionResponseBody = transactionResponse.getBody();
                return transactionResponseBody.getTransactions();
            } else {
                LOGGER.info("Error while fetching transactions for account number {}, and response code  {} ", accountNumber, transactionResponse.getStatusCode().toString());
            }

        } catch (Exception ex) {
            LOGGER.error("Error while fetching transactions for account number {}, and error message {} ", accountNumber, ex.getMessage());

        }
        return new ArrayList<>();
    }


}

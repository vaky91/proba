package org.infobip.campus.notifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by grumin on 11.8.2016.
 */
@Component
public class PushGateway implements Gateway {

    private static final Logger LOG = LoggerFactory.getLogger(PushGateway.class);

    //private static final String uri = "https://oneapi.infobip.com/push/1/single";
    // private String uri = "http://localhost:8080/push";
    //private String from  = "6dad0991ff524d69f84cd1ae07683895-cf5fc25c-9334-4e9a-bcf6-df8301bb1b6d";
    private String uri;
    private String from;
    HttpHeaders headers = new HttpHeaders();

    private final RestTemplate restTemplate = new RestTemplate();

    public PushGateway(String uri, String from, String authorizationKey) {
        this.uri = uri;
        this.from = from;
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.put("Authorization", Collections.singletonList("App " + authorizationKey));
    }

    @Override
    public void push(Collection<GatewayRequest> requests) {
        for (GatewayRequest gatewayRequest : requests) {
            HttpEntity<PushRequest> entity = new HttpEntity<>(new PushRequest(from, gatewayRequest.getReceiver().getNumber(),
                    gatewayRequest.getText()), headers);
            String response = restTemplate.postForObject(uri, entity, String.class);
            LOG.info(response);
        }
    }
}

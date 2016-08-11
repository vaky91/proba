package org.infobip.campus.notifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

/**
 * Created by grumin on 11.8.2016.
 */
@Component
public class PushGateway implements Gateway {

    private static final Logger LOG = LoggerFactory.getLogger(PushGateway.class);

    //private static final String uri = "https://oneapi.infobip.com/push/1/single";
    private static final String uri = "http://localhost:8080/push";
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public void push(Collection<GatewayRequest> requests) {
        for(GatewayRequest gatewayRequest : requests){
            String response = restTemplate.postForObject(uri, new PushRequest(gatewayRequest.getReceiver().getNumber(), gatewayRequest.getText()), String.class);
            LOG.info(response);
        }
    }
}

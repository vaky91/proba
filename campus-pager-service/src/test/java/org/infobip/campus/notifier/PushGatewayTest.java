package org.infobip.campus.notifier;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.Result;

import java.util.Collections;

import static org.junit.Assert.*;
import static com.github.tomakehurst.wiremock.client.WireMock.*;

/**
 * Created by grumin on 11.8.2016.
 */
public class PushGatewayTest {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule();

    @Test
    public void testPush() throws Exception {

        stubFor(post(urlEqualTo("/push"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{'response':'OK'}")));

        Gateway gateway = new PushGateway();
        gateway.push(Collections.singletonList(new GatewayRequest(new Member("13373420"), "Probni puš")));

        //assertTrue(result.wasSuccessFul());

        verify(postRequestedFor(urlMatching("/push"))
                .withRequestBody(equalTo("{\"from\":\"6dad0991ff524d69f84cd1ae07683895-cf5fc25c-9334-4e9a-bcf6-df8301bb1b6d\"," +
                        "\"to\":\"13373420\"," +
                        "\"text\":\"Probni puš\"}")));
    }
}
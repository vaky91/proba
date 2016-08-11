package org.infobip.campus.notifier;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;

import java.util.Collections;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

/**
 * Created by hbusic on 11.8.2016.
 */
public class SMSGatewayTest {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(15000);

    @Test
    public void smsTest() throws Exception {

        wireMockRule.
        stubFor(post(urlEqualTo("/sms"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{ \"response\" : \"OK\" }")));

        Gateway gateway = new SMSGateway("abcd", "http://localhost:15000/sms");
        gateway.push(Collections.singletonList(new GatewayRequest(new Member("13373420"), "Test SMS.")));

        //assertTrue(result.wasSuccessFul());

        verify(postRequestedFor(urlMatching("/sms"))
                .withRequestBody(equalTo("{\"from\":\"InfoSMS\"," +
                        "\"to\":\"13373420\"," +
                        "\"text\":\"Test SMS.\"}")));
    }
}
package org.infobip.campus.notifier;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;
import java.util.Collections;
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

        Gateway gateway = new PushGateway("http://localhost:8080/push",
        <"api-key">,
                <"from some user">);
        gateway.push(Collections.singletonList(new GatewayRequest(new Member(<number>), "Probni push")));

        verify(postRequestedFor(urlMatching("/push"))
                .withHeader("Authorization", equalTo(<"authorization">))
                .withHeader("Content-Type", equalTo("application/json"))
                .withHeader("Accept", equalTo("application/json"))
                .withRequestBody(equalTo("{\"from\":<\"from some user\">," +
                        "\"to\":<\"some number\">," +
                        "\"text\":\"Probni push\"}")));
    }
}

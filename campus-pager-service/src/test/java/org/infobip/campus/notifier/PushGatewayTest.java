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
                "6dad0991ff524d69f84cd1ae07683895-cf5fc25c-9334-4e9a-bcf6-df8301bb1b6d",
                "b7b1fc06983b3dff0aabece3973951f3-23e80b14-f291-4d6d-8af7-5146850d7602");
        gateway.push(Collections.singletonList(new GatewayRequest(new Member("13373420"), "Probni push")));

        verify(postRequestedFor(urlMatching("/push"))
                .withHeader("Authorization", equalTo("App b7b1fc06983b3dff0aabece3973951f3-23e80b14-f291-4d6d-8af7-5146850d7602"))
                .withHeader("Content-Type", equalTo("application/json"))
                .withHeader("Accept", equalTo("application/json"))
                .withRequestBody(equalTo("{\"from\":\"6dad0991ff524d69f84cd1ae07683895-cf5fc25c-9334-4e9a-bcf6-df8301bb1b6d\"," +
                        "\"to\":\"13373420\"," +
                        "\"text\":\"Probni push\"}")));
    }
}
package org.infobip.campus.api;

import org.infobip.campus.connector.model.TemplateRequest;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EchoTemplateServiceTest {

    @Test
    public void echoesRequest() {

        assertThat(new EchoTemplateService().getResponse(new TemplateRequest("wohooo!!!")).getResponse()).isEqualTo("wohooo!!!");

    }
}
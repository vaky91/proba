package org.infobip.campus.api;

import org.infobip.campus.Application;
import org.infobip.campus.connector.model.TemplateRequest;
import org.infobip.campus.connector.service.TemplateService;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

import static org.assertj.core.api.Assertions.assertThat;

@WebIntegrationTest("spring.profiles.active=test")
@SpringApplicationConfiguration(Application.class)
public class EchoTemplateServiceIT {

    @ClassRule
    public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();

    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();

    @Autowired
    @Qualifier(TestConfiguration.SELF_INVOKER_BEAN)
    private TemplateService templateServiceInvoker;

    @Test
    public void echoesRequestText() {

        assertThat(templateServiceInvoker.getResponse(new TemplateRequest("wohooo!!!")).getResponse()).isEqualTo("wohooo!!!");
    }
}
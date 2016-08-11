package org.infobip.campus.acceptor;

import org.infobip.campus.Application;
import org.infobip.campus.notifier.Gateway;
import org.infobip.campus.notifier.NotificationSender;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

/**
 * @author iobestar
 * @since 11.08.2016. 12:08
 */
@WebIntegrationTest("spring.profiles.active=test")
@SpringApplicationConfiguration(value = {Application.class})
public class AlertAcceptorControllerTestIT {

    @ClassRule
    public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();

    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();

}
package org.infobip.campus.config;

import org.infobip.campus.notifier.Gateway;
import org.infobip.campus.notifier.PushGateway;
import org.infobip.campus.notifier.SMSGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by grumin on 11.8.2016.
 * Created by hbusic on 11.8.2016.
 */
@Configuration
public class BeanConfig {

    private static final String PUSH_API_URL = "https://oneapi.infobip.com/push/1/single";
    private static final String SENDER = "6dad0991ff524d69f84cd1ae07683895-cf5fc25c-9334-4e9a-bcf6-df8301bb1b6d";
    private static final String SMS_API_URL = "https://api.infobip.com/sms/1/text/single";
    private static final String API_KEY = "b7b1fc06983b3dff0aabece3973951f3-23e80b14-f291-4d6d-8af7-5146850d7602";

    @Bean
    public Gateway pushGateway() {
        return new PushGateway(PUSH_API_URL, SENDER, API_KEY);
    }

    @Bean
    public SMSGateway smsGateway() {
        return new SMSGateway(API_KEY, SMS_API_URL);
    }
}

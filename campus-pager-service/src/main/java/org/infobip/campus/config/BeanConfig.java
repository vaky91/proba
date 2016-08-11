package org.infobip.campus.config;

import org.infobip.campus.notifier.SMSGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hbusic on 11.8.2016.
 */
@Configuration
public class BeanConfig {

    private static final String url = "https://api.infobip.com/sms/1/text/single";
    private static final String apiKey = "b7b1fc06983b3dff0aabece3973951f3-23e80b14-f291-4d6d-8af7-5146850d7602";

    @Bean
    public SMSGateway smsGateway() {
        return new SMSGateway(apiKey, url);
    }
}

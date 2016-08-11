package org.infobip.campus.config;

import org.infobip.campus.notifier.Gateway;
import org.infobip.campus.notifier.PushGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by grumin on 11.8.2016.
 */
@Configuration
public class BeanConfig {

    @Bean
    public Gateway pushGateway(){
        return new PushGateway("https://oneapi.infobip.com/push/1/single",
                "6dad0991ff524d69f84cd1ae07683895-cf5fc25c-9334-4e9a-bcf6-df8301bb1b6d",
                "b7b1fc06983b3dff0aabece3973951f3-23e80b14-f291-4d6d-8af7-5146850d7602");
    }
}

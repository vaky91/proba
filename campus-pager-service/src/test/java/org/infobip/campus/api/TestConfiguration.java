package org.infobip.campus.api;

import org.infobip.campus.connector.service.TemplateService;
import org.infobip.spring.remoting.client.RmiClientInterfaceRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration {

    public static final String SELF_INVOKER_BEAN = "templateServiceInvoker";

    @Bean
    public RmiClientInterfaceRegistrar registrar() {

        RmiClientInterfaceRegistrar registrar = new RmiClientInterfaceRegistrar();

        registrar.addModule("self")
                .addInterface(SELF_INVOKER_BEAN, TemplateService.class);

        return registrar;
    }

}

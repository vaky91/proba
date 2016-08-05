package org.infobip.campus.api;

import org.infobip.campus.connector.model.TemplateRequest;
import org.infobip.campus.connector.model.TemplateResponse;
import org.infobip.campus.connector.service.TemplateService;
import org.infobip.spring.remoting.server.export.Export;
import org.springframework.stereotype.Service;

@Service
@Export(TemplateService.class)
public class EchoTemplateService implements TemplateService {

    @Override
    public TemplateResponse getResponse(TemplateRequest request) {

        return new TemplateResponse(request.getRequest());
    }

}

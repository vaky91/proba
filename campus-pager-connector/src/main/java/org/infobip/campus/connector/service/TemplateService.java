package org.infobip.campus.connector.service;

import org.infobip.campus.connector.model.TemplateRequest;
import org.infobip.campus.connector.model.TemplateResponse;

public interface TemplateService {

    TemplateResponse getResponse(TemplateRequest request);

}

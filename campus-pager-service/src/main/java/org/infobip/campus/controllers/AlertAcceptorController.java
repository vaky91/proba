package org.infobip.campus.controllers;

import org.infobip.campus.dependencies.NotificationSender;
import org.infobip.campus.model.NotificationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by grumin on 10.8.2016.
 */
@RestController
public class AlertAcceptorController {

    private static Logger LOG = LoggerFactory.getLogger(AlertAcceptorController.class);

//    @Autowired
//    private NotificationSender notificationSender;

    @RequestMapping(value="/test/{groupId}", method= RequestMethod.POST, consumes="application/json", produces="application/json")
    public String test(@PathVariable String groupId, @RequestBody NotificationRequest request) {
        request.setGroupID(groupId);
        LOG.info(request.toString());
        //notificationSender.notify(request);
        return request.toString();
    }
}

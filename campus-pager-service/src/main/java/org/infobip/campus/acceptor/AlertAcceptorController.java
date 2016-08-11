package org.infobip.campus.acceptor;

import org.infobip.campus.acceptor.model.AlertRequest;
import org.infobip.campus.dependencies.NotificationSender;
import org.infobip.campus.model.NotificationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by grumin on 10.8.2016.
 */
@RestController
public class AlertAcceptorController {

    @Autowired
    private NotificationSender notificationSender;

    @RequestMapping(value="/test/{groupId}", method= RequestMethod.POST, consumes="application/json", produces="application/json")
    public ResponseEntity<String> test(@PathVariable String groupId, @RequestBody AlertRequest request) {

        notificationSender.notify(new NotificationRequest(groupId));
        return new ResponseEntity<String>("OK", HttpStatus.OK);
    }

}

package org.infobip.campus.controllers;

import org.infobip.campus.model.Alert;
import org.infobip.campus.model.AlertRequest;
import org.springframework.web.bind.annotation.*;

/**
 * Created by grumin on 10.8.2016.
 */
@RestController
public class AlertAcceptorController {

    @RequestMapping(value="/test", method= RequestMethod.POST, consumes="application/json", produces="application/json")
    public String test(@RequestBody AlertRequest request) {
        return request.toString();
    }
}

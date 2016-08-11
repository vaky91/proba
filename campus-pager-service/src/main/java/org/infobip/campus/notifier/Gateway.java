package org.infobip.campus.notifier;

import java.util.Collection;

/**
 * Gateway contract.
 * Created by hbusic on 10.8.2016.1
 */
public interface Gateway {

    void push(Collection<GatewayRequest> requests);
}

package org.infobip.campus.notifier;


import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.Collection;

/**
 * Gateway implementation for SMS notification.
 * Created by hbusic on 11.8.2016.
 */
public class SMSGateway implements Gateway {

    @Override
    public void push(Collection<GatewayRequest> requests) throws IOException {

        for (GatewayRequest r : requests) {

            SMSPackage smsPackage = new SMSPackage(
                    "InfoSMS",
                    r.getReceiver().getNumber(),
                    r.getText());

            ObjectMapper mapper = new ObjectMapper();
            String jsonInString  = mapper.writeValueAsString(smsPackage);

            String phrase = Request.Post("https://api.infobip.com/sms/1/text/single")
                    .addHeader("Authorization","App b7b1fc06983b3dff0aabece3973951f3-23e80b14-f291-4d6d-8af7-5146850d7602")
                    .addHeader("Accept", "application/json")
                    .bodyString(jsonInString, ContentType.APPLICATION_JSON)
                    .execute().returnResponse().getStatusLine().getReasonPhrase();
        }
    }
}

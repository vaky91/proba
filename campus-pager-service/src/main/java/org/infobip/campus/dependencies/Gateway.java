package org.infobip.campus.dependencies;

import java.util.Collection;

/**
 * Created by hbusic on 10.8.2016.
 */
public interface Gateway {

    void push(Collection<Member> members);
}

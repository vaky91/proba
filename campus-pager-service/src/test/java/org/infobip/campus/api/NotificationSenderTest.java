package org.infobip.campus.api;

import org.infobip.campus.dependencies.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.mockito.Mockito.*;

/**
 * Created by hbusic on 10.8.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class NotificationSenderTest {

    @Test
    public void firstTest() throws Exception {

        NotificationRequest request = mock(NotificationRequest.class);
        Repository repository = mock(Repository.class);
        Group group = mock(Group.class);
        Gateway SMSGate = mock(Gateway.class);
        Gateway PushGate = mock(Gateway.class);

        String ID = "nesto";
        when(request.getGroupID()).thenReturn(ID);
        when(repository.getGroupById(ID)).thenReturn(group);
        when(group.getMembers()).thenReturn(null);

        NotificationSender sender = new NotificationSender(repository, Arrays.asList(SMSGate,PushGate));
        sender.notify(request);

        verify(request,times(1)).getGroupID();
        verify(repository,times(1)).getGroupById(anyString());
        verify(group,times(1)).getMembers();
        verify(SMSGate,times(1)).push(anyCollection());
        verify(PushGate,times(1)).push(anyCollection());
    }

    @Test
    public void secondTest() throws Exception {

        NotificationRequest request = mock(NotificationRequest.class);
        Repository repository = mock(Repository.class);
        Group group = mock(Group.class);
        Gateway SMSGate = mock(Gateway.class);
        Gateway PushGate = mock(Gateway.class);

        String groupId = "infrastructure";

        when(request.getGroupID()).thenReturn(groupId);
        when(repository.getGroupById(groupId)).thenReturn(group);
        when(group.getMembers()).thenReturn(null);

        NotificationSender sender = new NotificationSender(repository, Arrays.asList(SMSGate,PushGate));
        sender.notify(request);

        verify(request,times(1)).getGroupID();
        verify(repository,times(1)).getGroupById(groupId);
        verify(group,times(1)).getMembers();



    }
}

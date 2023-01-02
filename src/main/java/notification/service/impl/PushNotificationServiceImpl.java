package notification.service.impl;

import notification.request.SendNotificationRequest;
import notification.response.SendNotificationResponse;
import notification.service.NotificationService;
import org.springframework.stereotype.Service;

@Service("push")
public class PushNotificationServiceImpl implements NotificationService {
    @Override
    public String getType() {
        return "push";
    }

    @Override
    public SendNotificationResponse send(SendNotificationRequest request) {
        SendNotificationResponse response = new SendNotificationResponse();
        System.out.println("Push Notification Working");
        return response;
    }
}

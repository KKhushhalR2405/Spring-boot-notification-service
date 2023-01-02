package notification.service;

import notification.request.SendNotificationRequest;
import notification.response.SendNotificationResponse;

public interface NotificationService {
    String getType();
    SendNotificationResponse send(SendNotificationRequest request);
}

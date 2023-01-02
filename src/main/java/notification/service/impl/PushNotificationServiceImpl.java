package notification.service.impl;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import lombok.extern.slf4j.Slf4j;
import notification.request.SendNotificationRequest;
import notification.response.SendNotificationResponse;
import notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("push")
@Slf4j
public class PushNotificationServiceImpl implements NotificationService {

    @Autowired
    private FirebaseMessaging firebaseMessaging;

    @Override
    public String getType() {
        return "push";
    }

    @Override
    public SendNotificationResponse send(SendNotificationRequest request) {
        SendNotificationResponse response;
        try{
            Notification notification = Notification
                    .builder()
                    .setTitle(request.getSubject())
                    .setBody(request.getContent())
                    .build();

            Message message = Message
                    .builder()
                    .setToken(request.getToken())
                    .setNotification(notification)
                    .putAllData(request.getData())
                    .build();

            String result = firebaseMessaging.send(message);
            log.info("Response from firebaseMessaging : {}",result);
            response = new SendNotificationResponse(200, "SUCCESS");
        } catch (Exception e) {
            log.info("Exception occurred in Sending Push Notification!!!!");
            response = new SendNotificationResponse(500, "FAILURE", e.getMessage());
        }
        return response;
    }
}

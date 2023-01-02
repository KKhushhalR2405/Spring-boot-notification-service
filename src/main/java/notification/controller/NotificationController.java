package notification.controller;

import notification.request.SendNotificationRequest;
import notification.response.SendNotificationResponse;
import notification.service.NotificationProviderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    @Autowired
    private NotificationProviderFactory notificationProviderFactory;

    @PostMapping("/notification/send")
    public ResponseEntity<SendNotificationResponse> sendNotification(
            @RequestBody SendNotificationRequest request
    ){
        SendNotificationResponse response = notificationProviderFactory.getService(request.getChannelType()).send(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}

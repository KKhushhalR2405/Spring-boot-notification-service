package notification.service.impl;

import lombok.extern.slf4j.Slf4j;
import notification.helper.EmailNotificationSenderHelper;
import notification.request.SendNotificationRequest;
import notification.response.SendNotificationResponse;
import notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("email")
@Slf4j
public class EmailNotificationServiceImpl implements NotificationService {

    @Autowired
    private EmailNotificationSenderHelper emailNotificationSenderHelper;

    @Override
    public String getType() {
        return "email";
    }

    @Override
    public SendNotificationResponse send(SendNotificationRequest request) {
        log.info("START send() with email: {}", request.getEmailId());
        SendNotificationResponse response;
        try{
            emailNotificationSenderHelper.sendEmail(request);
            response = new SendNotificationResponse(200, "SUCCESS");
            log.info("Mail Sent Successfully to {}",request.getEmailId());
        } catch (Exception e){
            log.info("Exception occurred in sending Email Notification");
            log.error("Exception occurred in send()", e);
            response = new SendNotificationResponse(500, "FAILURE",e.getMessage());
        }
        log.info("END send() with status : {}", response.getResDesc());
        return response;
    }


}

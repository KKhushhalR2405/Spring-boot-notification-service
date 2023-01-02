package notification.service.impl;

import lombok.extern.slf4j.Slf4j;
import notification.request.SendNotificationRequest;
import notification.response.SendNotificationResponse;
import notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service("email")
@Slf4j
public class EmailNotificationServiceImpl implements NotificationService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public String getType() {
        return "email";
    }

    @Override
    public SendNotificationResponse send(SendNotificationRequest request) {
        SendNotificationResponse response;
        try{
            SendEmail(request);
            response = new SendNotificationResponse(200, "SUCCESS");
            log.info("Mail Sent Successfully to {}",request.getEmailId());
        } catch (Exception e){
            response = new SendNotificationResponse(500, "FAILURE");
        }

        return response;
    }

    @Async
    private void SendEmail(SendNotificationRequest request){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("reddykhushhal2405@gmail.com");
        message.setTo(request.getEmailId());
        message.setText(request.getBody());
        message.setSubject(request.getSubject());

        javaMailSender.send(message);
    }
}

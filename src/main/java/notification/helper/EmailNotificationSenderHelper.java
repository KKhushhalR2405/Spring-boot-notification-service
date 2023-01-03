package notification.helper;


import notification.request.SendNotificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationSenderHelper {
    @Value("${spring.mail.username}")
    private String senderMailId;

    @Autowired
    private JavaMailSender javaMailSender;
    @Async
    public void sendEmail(SendNotificationRequest request){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(senderMailId);
        message.setTo(request.getEmailId());
        message.setText(request.getBody());
        message.setSubject(request.getSubject());

        javaMailSender.send(message);
    }
}

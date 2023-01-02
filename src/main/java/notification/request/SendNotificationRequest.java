package notification.request;

import lombok.Data;

import java.util.Map;

@Data
public class SendNotificationRequest {

    private String channelType;

    // Push and Email
    private String subject;

    //Email
    private String emailId;
    private String body;

    //Push
    private String content;
    private String topic;
    private String title;
    private String message;
    private Map<String, String> data;
    private String image;
    private String token;

}

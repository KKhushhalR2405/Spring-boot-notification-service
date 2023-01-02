package notification.request;

import lombok.Data;

@Data
public class SendNotificationRequest {

    private String channelType;

    //Email
    private String emailId;
    private String subject;
    private String body;

}

package notification.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendNotificationResponse {
    private Integer resCode;
    private String resDesc;
    private String errorDesc;

    public SendNotificationResponse(int code, String desc){
        this.resCode = code;
        this.resDesc = desc;
    }
}

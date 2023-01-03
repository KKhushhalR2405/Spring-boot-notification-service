package notification.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include. NON_NULL)
public class SendNotificationResponse {
    private Integer resCode;
    private String resDesc;
    private String errorDesc;

    public SendNotificationResponse(int code, String desc){
        this.resCode = code;
        this.resDesc = desc;
    }
}

package notification.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ChannelTypeNotFoundException extends RuntimeException{
    private String message;

    public ChannelTypeNotFoundException(String message){
        super(message);
        this.message = message;
    }
}

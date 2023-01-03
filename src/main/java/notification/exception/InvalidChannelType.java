package notification.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidChannelType extends RuntimeException{
    private String message;

    public InvalidChannelType(String message){
        super(message);
        this.message = message;
    }
}

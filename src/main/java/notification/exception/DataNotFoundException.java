package notification.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DataNotFoundException extends RuntimeException{

    private String message;

    public DataNotFoundException(String message){
        super(message);
        this.message = message;
    }

}

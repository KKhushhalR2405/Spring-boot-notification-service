package notification.advice;

import notification.exception.ChannelTypeNotFoundException;
import notification.exception.DataNotFoundException;
import notification.exception.InvalidChannelType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(NullPointerException nullPointerException){
        return new ResponseEntity<>("Field is Empty", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<String> handleDataNotFoundException(DataNotFoundException dataNotFoundException){
        return new ResponseEntity<>(dataNotFoundException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ChannelTypeNotFoundException.class)
    public ResponseEntity<String> handleChannelTypeNotFoundException(ChannelTypeNotFoundException channelTypeNotFoundException){
        return new ResponseEntity<>(channelTypeNotFoundException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidChannelType.class)
    public ResponseEntity<String> handleInvalidChannelTypeException(InvalidChannelType invalidChannelType){
        return new ResponseEntity<>(invalidChannelType.getMessage(), HttpStatus.BAD_REQUEST);
    }

}

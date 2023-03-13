package hr.neos.aleksaeventmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.MethodNotAllowedException;

import java.util.Date;
import java.util.NoSuchElementException;


@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = IllegalStateException.class)
    public ResponseEntity<ErrorDetails> handleIllegalStateException(IllegalStateException ex) {
        ErrorDetails errorDetails = this.prepareErrorDetails(ex);
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NoSuchElementException.class)
    public ResponseEntity<ErrorDetails> handleNoSuchElementException(NoSuchElementException ex){
        ErrorDetails errorDetails = this.prepareErrorDetails(ex);
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = MethodNotAllowedException.class)
    public ResponseEntity<ErrorDetails> handleMethodNotAllowedException(MethodNotAllowedException ex) {
        ErrorDetails errorDetails = this.prepareErrorDetails(ex);
        return new ResponseEntity<>(errorDetails, HttpStatus.METHOD_NOT_ALLOWED);
    }

    private ErrorDetails prepareErrorDetails(Exception exception) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setTimestamp(new Date());
        errorDetails.setMessage(exception.getMessage());
        return errorDetails;
    }
}

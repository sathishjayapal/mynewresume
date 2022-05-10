package mynewresume.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class ResumeReaderExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ResumeExceptionMessage resumeExceptionMessage = new ResumeExceptionMessage(new Date(), ex.getMessage(), "This is a generic exception");
        request.getDescription(false);
        return new ResponseEntity<>(resumeExceptionMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    protected ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) {
        ResumeExceptionMessage resumeExceptionMessage = new ResumeExceptionMessage(new Date(), ex.getMessage(), "This is user not found exception");
        request.getDescription(false);
        return new ResponseEntity(resumeExceptionMessage, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ResumeExceptionMessage resumeExceptionMessage = new ResumeExceptionMessage(new Date(), ex.getMessage(), "This is user not found exception");
        request.getDescription(false);
        return new ResponseEntity(resumeExceptionMessage, HttpStatus.NOT_FOUND);
    }
}

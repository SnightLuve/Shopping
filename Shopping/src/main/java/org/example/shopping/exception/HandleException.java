package org.example.shopping.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class HandleException {
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    //    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public  ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex,
//                                                                         WebRequest request,
//                                                                         HttpHeaders headers,
//                                                                         HttpStatusCode statusCode
//                                                                         ) {
//        List<String> errors = new ArrayList<>();
//        for(FieldError error : ex.getBindingResult().getFieldErrors()) {
//            errors.add(error.getField()+": "+error.getDefaultMessage());
//        }
//        for(ObjectError error : ex.getBindingResult().getGlobalErrors()) {
//            errors.add(error.getObjectName()+": "+error.getDefaultMessage());
//        }
//        ResponseObject<?> responseObject=ResponseObject.builder()
//                .success(false)
//                .status(HttpStatus.BAD_REQUEST)
//                .message(ex.getMessage())
//                .errors(errors)
//                .build();
//        return handleExceptionInternal(ex, responseObject, headers, responseObject.getStatus(), request);
//    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
        ErrorResponse error = new ErrorResponse();
        error.setTimestamp(new Date());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setPath(request.getDescription(false).replace("uri=", ""));
        error.setError("Payload Invalid");
        String message = ex.getMessage();
        int start = message.lastIndexOf("[");
        int end = message.lastIndexOf("]");
        message = message.substring(start + 1, end);
        error.setMessage(message);
        return error;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleConstraintViolationException(ConstraintViolationException ex, WebRequest request) {
        ErrorResponse error = new ErrorResponse();
        error.setTimestamp(new Date());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setPath(request.getDescription(false).replace("uri=", ""));
        error.setError("Parameter Invalid");
        String message = ex.getMessage();
        message = message.substring(message.indexOf("") + 1);
        error.setMessage(message);
        return error;
    }

}



package br.com.s3alugueis.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ExceptionDTO generalException(Exception exception){
        return new ExceptionDTO(exception.getMessage(),HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(RuntimeException.class)
    public ExceptionDTO generalRuntimeException(RuntimeException exception){
        return new ExceptionDTO(exception.getMessage(),HttpStatus.BAD_REQUEST);
    }
}
record ExceptionDTO(String messege, HttpStatus status){}
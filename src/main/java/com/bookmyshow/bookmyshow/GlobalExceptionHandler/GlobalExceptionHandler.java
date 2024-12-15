package com.bookmyshow.bookmyshow.GlobalExceptionHandler;

import com.bookmyshow.bookmyshow.Exceptions.ShowSeatNotFoundException;
import com.bookmyshow.bookmyshow.Exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleUserNotFoundException() {
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ShowSeatNotFoundException.class)
    public ResponseEntity<?> handleShowSeatNotFoundException() {
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

package by.milosh.controller;

import by.milosh.exception.IncorrectFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ReducerControllerHelper {

    @ExceptionHandler(IncorrectFormatException.class)
    public ResponseEntity<String> handleIOException(IncorrectFormatException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.TEXT_PLAIN)
                .body(exception.getMessage());
    }
}

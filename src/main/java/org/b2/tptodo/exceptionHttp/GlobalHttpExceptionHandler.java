package org.b2.tptodo.exceptionHttp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;
import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalHttpExceptionHandler {

    //erreur 404
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Map<String, String>> handleNotFound(NoSuchElementException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap("message", e.getMessage()));
    }

    //erreur 400
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleBadRequest(IllegalArgumentException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap("message", e.getMessage()));
    }
}
package com.litethinking.msuser.controller;

import com.litethinking.msuser.exceptionhandler.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseBody
    public ResponseEntity<String> sqlException(DataIntegrityViolationException ex) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Error en el REQUEST: " + ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<String> handlerException(Exception ex) {
        log.error("Se produjo un error no controlado a nivel del servidor", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno de servidor");
    }


    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseBody
    public ResponseEntity<String> resourceNotFoundException(Exception ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }
}

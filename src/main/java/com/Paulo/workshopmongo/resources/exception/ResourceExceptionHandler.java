package com.Paulo.workshopmongo.resources.exception;

import com.Paulo.workshopmongo.services.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // classe responsável por tratar possiveis erros nas minhas aquisições
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class) // quando ocorrer essa exceção, fazer esse tratamento aqui
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Not found!", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}

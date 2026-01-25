package com.estanciero.api.controllers;

import com.estanciero.api.dtos.common.ErrorApi;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.time.LocalDateTime;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorApi> handleException(Exception ex) {
        ErrorApi error = buildError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorApi> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        //combina todos los mensajes de error de cada excepción
        String errorMessages = ex.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining(","));

        ErrorApi error = buildError(HttpStatus.BAD_REQUEST, errorMessages);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    // not found
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorApi> handleNoSuchElementException(NoSuchElementException ex) {
        ErrorApi error = buildError(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    //concurrencia
    @ExceptionHandler(ObjectOptimisticLockingFailureException.class)
    public ResponseEntity<ErrorApi> handleConcurrency(ObjectOptimisticLockingFailureException ex) {

        String message = "The lobby changed while you were trying to join. Please try again.";
        ErrorApi error = buildError(HttpStatus.CONFLICT, message + ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(error);
    }

    //estado inválido
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ErrorApi> handleIllegalState(IllegalStateException ex) {
        ErrorApi error = buildError(HttpStatus.CONFLICT, ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    //argumentos invalidos
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorApi> handleIllegalArgument(IllegalArgumentException ex) {
        ErrorApi error = buildError(HttpStatus.BAD_REQUEST, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }


    /**
     * Construye un objeto {@link ErrorApi} con los datos del error.
     *
     * @param status  código HTTP.
     * @param message mensaje descriptivo.
     * @return objeto de error.
     */
    private ErrorApi buildError(HttpStatus status, String message) {
        return ErrorApi.builder()
                .timestamp(LocalDateTime.now().toString())
                .status(status.value())
                .error(status.getReasonPhrase())
                .message(message).build();
    }


}

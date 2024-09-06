package com.prueba.zara.fvillegasos.PruebaTecnicaZara.controller;

import com.prueba.zara.fvillegasos.PruebaTecnicaZara.exception.CustomErrorEnum;
import com.prueba.zara.fvillegasos.PruebaTecnicaZara.exception.CustomHttpError;
import com.prueba.zara.fvillegasos.PruebaTecnicaZara.exception.CustomHttpException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomHttpException.class)
    public ResponseEntity<CustomHttpError> handleException(CustomHttpException customHttpException) {
        return getResponseEntityError(customHttpException);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomHttpError> handleException() {
        var genericInternalServerError = CustomHttpException.of(CustomErrorEnum.GENERIC_INTERNAL_SERVER_ERROR);
        return getResponseEntityError(genericInternalServerError);
    }

    private ResponseEntity<CustomHttpError> getResponseEntityError(CustomHttpException customHttpException) {
        return ResponseEntity.status(customHttpException.getHttpStatusCode()).body(buildHttpError(customHttpException));
    }

    private CustomHttpError buildHttpError(CustomHttpException customHttpException) {
        return new CustomHttpError(customHttpException.getHttpStatusCode().value(), customHttpException.getMessage());
    }
}

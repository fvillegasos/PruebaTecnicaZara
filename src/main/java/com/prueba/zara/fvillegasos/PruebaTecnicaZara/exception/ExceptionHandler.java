package com.prueba.zara.fvillegasos.PruebaTecnicaZara.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class ExceptionHandler {

    public static ResponseStatusException of(CustomErrorEnum customErrorEnum) {
        return new ResponseStatusExceptionBuilder()
                .withStatus(customErrorEnum.getStatusCode())
                .withCustomMessage(customErrorEnum.getMessage())
                .buildStatusException();
    }
}

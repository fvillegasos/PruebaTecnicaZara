package com.prueba.zara.fvillegasos.PruebaTecnicaZara.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class ResponseStatusExceptionBuilder {

    private String customMessage;
    private HttpStatusCode status;

    public ResponseStatusExceptionBuilder withCustomMessage(String customMessage) {
        this.customMessage = customMessage;
        return this;
    }

    public ResponseStatusExceptionBuilder withStatus(HttpStatusCode status) {
        this.status = status;
        return this;
    }

    public ResponseStatusException buildStatusException() {
        return new ResponseStatusException(status, customMessage);
    }

}

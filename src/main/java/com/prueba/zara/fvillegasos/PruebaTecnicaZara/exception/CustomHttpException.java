package com.prueba.zara.fvillegasos.PruebaTecnicaZara.exception;

import org.springframework.http.HttpStatusCode;

public class CustomHttpException extends RuntimeException {

    private HttpStatusCode httpStatusCode;

    private CustomHttpException(String message, HttpStatusCode httpStatusCode) {
        super(message);
        this.httpStatusCode = httpStatusCode;
    }

    public HttpStatusCode getHttpStatusCode() {
        return httpStatusCode;
    }

    public static CustomHttpException of(CustomErrorEnum customErrorEnum) {
        return new CustomHttpException(customErrorEnum.getMessage(), customErrorEnum.getStatusCode());
    }
}

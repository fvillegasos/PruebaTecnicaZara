package com.prueba.zara.fvillegasos.PruebaTecnicaZara.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public enum CustomErrorEnum {

    NOT_FOUND_PRODUCT_PRICE(HttpStatus.NOT_FOUND, "Price for the given filters could not be found!"),
    GENERIC_INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected error in any layer of the microservice (controller, service, repository, etc.)!");

    private final HttpStatusCode statusCode;
    private final String message;
    CustomErrorEnum(HttpStatusCode statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public HttpStatusCode getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}

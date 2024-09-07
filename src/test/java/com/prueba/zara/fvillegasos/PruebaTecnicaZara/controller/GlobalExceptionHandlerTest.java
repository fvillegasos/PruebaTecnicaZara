package com.prueba.zara.fvillegasos.PruebaTecnicaZara.controller;

import com.prueba.zara.fvillegasos.PruebaTecnicaZara.exception.CustomErrorEnum;
import com.prueba.zara.fvillegasos.PruebaTecnicaZara.exception.CustomHttpException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

@SpringBootTest
class GlobalExceptionHandlerTest {

    @Autowired
    private GlobalExceptionHandler globalExceptionHandler;

    @Test
    void when_handleCustomException_thenReturn_ResponseEntityCustomError() {
        var responseEntity = globalExceptionHandler.handleCustomException(CustomHttpException.of(CustomErrorEnum.NOT_FOUND_PRODUCT_PRICE));
        Assertions.assertAll(
                () -> Assertions.assertNotNull(responseEntity),
                () -> Assertions.assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode()),
                () -> Assertions.assertNotNull(responseEntity.getBody()),
                () -> Assertions.assertNotNull(responseEntity.getBody().getMessage()),
                () -> Assertions.assertNotNull(responseEntity.getBody().getDateOfError()),
                () -> Assertions.assertNotNull(responseEntity.getBody().getStatus())
        );
    }

    @Test
    void when_handleException_thenReturn_ResponseEntityCustomError() {
        var responseEntity = globalExceptionHandler.handleException();
        Assertions.assertAll(
                () -> Assertions.assertNotNull(responseEntity),
                () -> Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode()),
                () -> Assertions.assertNotNull(responseEntity.getBody()),
                () -> Assertions.assertNotNull(responseEntity.getBody().getMessage()),
                () -> Assertions.assertNotNull(responseEntity.getBody().getDateOfError()),
                () -> Assertions.assertNotNull(responseEntity.getBody().getStatus())
        );
    }

}

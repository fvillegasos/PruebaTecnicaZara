package com.prueba.zara.fvillegasos.PruebaTecnicaZara.controller;

import com.prueba.zara.fvillegasos.PruebaTecnicaZara.model.ProductPriceInfo;
import com.prueba.zara.fvillegasos.PruebaTecnicaZara.service.ProductPriceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@SpringBootTest
class ProductControllerTest {

    @Mock
    private ProductPriceService productPriceService;
    @InjectMocks
    private ProductController controller;

    @Test
    void when_getProductPrice_thenReturn_200() {
        Mockito.when(productPriceService.getProductPriceInfo(Mockito.any(), Mockito.any(), Mockito.any()))
                .thenReturn(new ProductPriceInfo());

        var result = controller.getProductPrice(BigDecimal.ONE, OffsetDateTime.now(), BigDecimal.ONE);

        Assertions.assertAll(
                () -> Assertions.assertNotNull(result),
                () -> Assertions.assertEquals(HttpStatus.OK, result.getStatusCode()),
                () -> Assertions.assertNotNull(result.getBody())
        );
    }

}

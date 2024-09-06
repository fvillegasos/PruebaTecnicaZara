package com.prueba.zara.fvillegasos.PruebaTecnicaZara.service;

import com.prueba.zara.fvillegasos.PruebaTecnicaZara.entity.ProductPriceEntity;
import com.prueba.zara.fvillegasos.PruebaTecnicaZara.exception.CustomHttpException;
import com.prueba.zara.fvillegasos.PruebaTecnicaZara.mapper.ProductPriceMapper;
import com.prueba.zara.fvillegasos.PruebaTecnicaZara.model.ProductPriceInfo;
import com.prueba.zara.fvillegasos.PruebaTecnicaZara.repository.ProductPriceRepository;
import com.prueba.zara.fvillegasos.PruebaTecnicaZara.service.impl.ProductPriceServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Optional;

@SpringBootTest
class ProductServiceImplTest {

    @Mock
    private ProductPriceRepository productPriceRepository;
    @Mock
    private ProductPriceMapper productPriceMapper;
    @InjectMocks
    private ProductPriceServiceImpl productPriceService;

    @Test
    void when_getProductPriceInfo_thenReturn_ProductPriceInfo() {
        Mockito.when(productPriceRepository.findPriorityProductPriceByProductIdBrandIdAndApplicationDate(Mockito.anyLong(), Mockito.anyLong(), Mockito.any()))
                .thenReturn(Optional.of(new ProductPriceEntity()));
        Mockito.when(productPriceMapper.fromEntityToApiDto(Mockito.any()))
                .thenReturn(new ProductPriceInfo());

        var result = productPriceService.getProductPriceInfo(BigDecimal.ONE, BigDecimal.ONE, OffsetDateTime.now());

        Assertions.assertNotNull(result);
    }

    @Test
    void when_getProductPriceInfo_thenReturn_CustomHttpException_404() {
        Mockito.when(productPriceRepository.findPriorityProductPriceByProductIdBrandIdAndApplicationDate(Mockito.anyLong(), Mockito.anyLong(), Mockito.any()))
                .thenReturn(Optional.empty());
        try {
            productPriceService.getProductPriceInfo(BigDecimal.ONE, BigDecimal.ONE, OffsetDateTime.now());
        } catch (CustomHttpException customHttpException) {
            Assertions.assertAll(
                    () -> Assertions.assertNotNull(customHttpException),
                    () -> Assertions.assertEquals(HttpStatus.NOT_FOUND, customHttpException.getHttpStatusCode()),
                    () -> Assertions.assertNotNull(customHttpException.getMessage())
            );
        }
    }

}

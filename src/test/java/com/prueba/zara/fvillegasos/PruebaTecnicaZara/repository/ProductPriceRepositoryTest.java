package com.prueba.zara.fvillegasos.PruebaTecnicaZara.repository;

import com.prueba.zara.fvillegasos.PruebaTecnicaZara.repository.ProductPriceRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

@DataJpaTest
class ProductPriceRepositoryTest {

    @Autowired
    private ProductPriceRepository repository;

    @Test
    void when_ProductId_BrandId_ApplicationDate_thenReturn_ProductPriceEntity() {
        var applicationDate = LocalDateTime.of(2020, 6, 14, 2, 0, 0);
        var optEntity = repository.findPriorityProductPriceByProductIdBrandIdAndApplicationDate(35455L, 1L, applicationDate);
        Assertions.assertAll(
                () -> Assertions.assertNotNull(optEntity),
                () -> Assertions.assertTrue(optEntity.isPresent()),
                () -> Assertions.assertNotNull(optEntity.get()));
    }

}

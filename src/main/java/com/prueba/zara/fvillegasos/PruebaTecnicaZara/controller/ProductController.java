package com.prueba.zara.fvillegasos.PruebaTecnicaZara.controller;

import com.prueba.zara.fvillegasos.PruebaTecnicaZara.api.ProductApi;
import com.prueba.zara.fvillegasos.PruebaTecnicaZara.model.ProductPriceInfo;
import com.prueba.zara.fvillegasos.PruebaTecnicaZara.service.ProductPriceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@RestController
public class ProductController implements ProductApi {

    private final ProductPriceService productPriceService;

    public ProductController(ProductPriceService productPriceService) {
        this.productPriceService = productPriceService;
    }

    @Override
    public ResponseEntity<ProductPriceInfo> getProductPrice(BigDecimal productId, OffsetDateTime applicationDate, BigDecimal brandId) {
        return ResponseEntity.ok(productPriceService.getProductPriceInfo(productId, brandId, applicationDate));
    }
}

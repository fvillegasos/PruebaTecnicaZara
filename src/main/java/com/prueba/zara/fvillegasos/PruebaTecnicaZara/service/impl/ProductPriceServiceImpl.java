package com.prueba.zara.fvillegasos.PruebaTecnicaZara.service.impl;

import com.prueba.zara.fvillegasos.PruebaTecnicaZara.exception.CustomErrorEnum;
import com.prueba.zara.fvillegasos.PruebaTecnicaZara.exception.ExceptionHandler;
import com.prueba.zara.fvillegasos.PruebaTecnicaZara.mapper.ProductPriceMapper;
import com.prueba.zara.fvillegasos.PruebaTecnicaZara.model.ProductPriceInfo;
import com.prueba.zara.fvillegasos.PruebaTecnicaZara.repository.ProductPriceRepository;
import com.prueba.zara.fvillegasos.PruebaTecnicaZara.service.ProductPriceService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class ProductPriceServiceImpl implements ProductPriceService {

    private final ProductPriceRepository repository;
    private final ProductPriceMapper mapper;

    public ProductPriceServiceImpl(ProductPriceRepository repository, ProductPriceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ProductPriceInfo getProductPriceInfo(BigDecimal productId, BigDecimal brandId, OffsetDateTime applicationDate) {
        try {
            var optProductPrice = repository.findPriorityProductPriceByProductIdBrandIdAndApplicationDate(productId.longValue(), brandId.longValue(), applicationDate.toLocalDateTime());

            if (optProductPrice.isEmpty()) {
                throw ExceptionHandler.of(CustomErrorEnum.NOT_FOUND_PRODUCT_PRICE);
            }

            return mapper.fromEntityToApiDto(optProductPrice.get());

        } catch (Exception exception) {
            throw ExceptionHandler.of(CustomErrorEnum.GENERIC_INTERNAL_SERVER_ERROR);
        }
    }
}

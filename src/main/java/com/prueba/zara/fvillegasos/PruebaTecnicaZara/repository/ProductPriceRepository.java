package com.prueba.zara.fvillegasos.PruebaTecnicaZara.repository;

import com.prueba.zara.fvillegasos.PruebaTecnicaZara.entity.ProductPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductPriceRepository extends JpaRepository<ProductPriceEntity, Long> {

    @Query(value = "SELECT price from ProductPriceEntity price WHERE " +
            "price.product.productId = :productId AND " +
            "price.brand.brandId = :brandId AND " +
            "price.startDate <= :applicationDate AND " +
            "price.endDate >= :applicationDate " +
            "ORDER BY price.priority DESC")
    List<ProductPriceEntity> findPriorityProductPriceByProductIdBrandIdAndApplicationDate(Long productId, Long brandId, LocalDateTime applicationDate);

}

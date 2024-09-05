package com.prueba.zara.fvillegasos.PruebaTecnicaZara.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "PRODUCT")
public class ProductEntity {

    @Id
    @Column(name = "PRODUCT_ID", nullable = false)
    private Long productId;

    @Column(name = "NAME", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BRAND_ID", nullable = false)
    private BrandEntity brandEntity;

    public ProductEntity() {
    }

    public ProductEntity(Long productId, String name, BrandEntity brandEntity) {
        this.productId = productId;
        this.name = name;
        this.brandEntity = brandEntity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BrandEntity getBrandEntity() {
        return brandEntity;
    }

    public void setBrandEntity(BrandEntity brandEntity) {
        this.brandEntity = brandEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return Objects.equals(productId, that.productId) && Objects.equals(name, that.name) && Objects.equals(brandEntity.getBrandId(), that.brandEntity.getBrandId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, name, brandEntity);
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", brandEntity=" + brandEntity.toString() +
                '}';
    }
}

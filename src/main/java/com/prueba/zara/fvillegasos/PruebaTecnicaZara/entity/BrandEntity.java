package com.prueba.zara.fvillegasos.PruebaTecnicaZara.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "BRAND")
public class BrandEntity {

    @Id
    @Column(name = "BRAND_ID", nullable = false)
    private Long brandId;

    @Column(name = "NAME", nullable = false)
    private String name;

    public BrandEntity(Long brandId, String name) {
        this.brandId = brandId;
        this.name = name;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrandEntity that = (BrandEntity) o;
        return Objects.equals(brandId, that.brandId) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandId, name);
    }

    @Override
    public String toString() {
        return "BrandEntity{" +
                "brandId=" + brandId +
                ", name='" + name + '\'' +
                '}';
    }
}

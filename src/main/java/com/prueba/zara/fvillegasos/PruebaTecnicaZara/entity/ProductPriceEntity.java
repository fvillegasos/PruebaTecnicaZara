package com.prueba.zara.fvillegasos.PruebaTecnicaZara.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.stream.Stream;

@Entity
@Table(name = "PRODUCT_PRICE")
@SequenceGenerator(name="PRODUCT_PRICE_SEQ_GNR",sequenceName="PRODUCT_PRICE_SEQ", allocationSize = 1)
public class ProductPriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_PRICE_SEQ_GNR")
    @Column(name = "PRODUCT_PRICE_ID", nullable = false)
    private Long productPriceId;

    @ManyToOne
    @JoinColumn(name = "BRAND_ID", nullable = false)
    private BrandEntity brandId;

    @Column(name = "START_DATE", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "END_DATE", nullable = false)
    private LocalDateTime endDate;

    @Column(name = "FEE", nullable = false)
    private Long fee;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private ProductEntity productId;

    @Column(name = "PRIORITY", nullable = false)
    private Long priority;

    @Column(name = "PRICE", nullable = false)
    private Double price;

    @Column(name = "CURR", nullable = false)
    private String curr;

    public ProductPriceEntity(Long productPriceId, BrandEntity brandId, LocalDateTime startDate, LocalDateTime endDate, Long fee, ProductEntity productId, Long priority, Double price, String curr) {
        this.productPriceId = productPriceId;
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.fee = fee;
        this.productId = productId;
        this.priority = priority;
        this.price = price;
        this.curr = curr;
    }

    public Long getProductPriceId() {
        return productPriceId;
    }

    public void setProductPriceId(Long productPriceId) {
        this.productPriceId = productPriceId;
    }

    public BrandEntity getBrandId() {
        return brandId;
    }

    public void setBrandId(BrandEntity brandId) {
        this.brandId = brandId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Long getFee() {
        return fee;
    }

    public void setFee(Long fee) {
        this.fee = fee;
    }

    public ProductEntity getProductId() {
        return productId;
    }

    public void setProductId(ProductEntity productId) {
        this.productId = productId;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCurr() {
        return curr;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductPriceEntity that = (ProductPriceEntity) o;
        return Objects.equals(productPriceId, that.productPriceId) && Objects.equals(brandId, that.brandId) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate) && Objects.equals(fee, that.fee) && Objects.equals(productId, that.productId) && Objects.equals(priority, that.priority) && Objects.equals(price, that.price) && Objects.equals(curr, that.curr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productPriceId, brandId, startDate, endDate, fee, productId, priority, price, curr);
    }

    @Override
    public String toString() {
        return "ProductPriceEntity{" +
                "productPriceId=" + productPriceId +
                ", brandId=" + brandId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", fee=" + fee +
                ", productId=" + productId +
                ", priority=" + priority +
                ", price=" + price +
                ", curr='" + curr + '\'' +
                '}';
    }
}

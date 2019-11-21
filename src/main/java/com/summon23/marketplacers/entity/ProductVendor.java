package com.summon23.marketplacers.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "product_vendor")
public class ProductVendor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double tierCogsPrice_1;

    @Column(name = "vendor_id")
    private String vendorId;

    private String currency;

    @Column(name = "stock_available")
    private Integer productVariantId;

    @ManyToOne
    @JoinColumn(name = "product_variant_id")
    @JsonIgnore
    private ProductVariant catalog;

    public ProductVendor() {
        super();
    }

    public ProductVendor(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTierCogsPrice1() {
        return tierCogsPrice_1;
    }

    public void setTierCogsPrice1(Double tierCogsPrice1) {
        this.tierCogsPrice_1 = tierCogsPrice1;
    }

    public ProductVariant getCatalog() {
        return catalog;
    }

    public void setCatalog(ProductVariant catalog) {
        this.catalog = catalog;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getProductVariantId() {
        return productVariantId;
    }

    public void setProductVariantId(Integer productVariantId) {
        this.productVariantId = productVariantId;
    }
}

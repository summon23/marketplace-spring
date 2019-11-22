package com.summon23.marketplacers.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "product_variant")
public class ProductVariant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String sku;

    private String longName;

    private String primaryImage;

    @OneToMany(mappedBy = "catalog")
    private List<ProductVendor> catalogVendors;

    @CreationTimestamp
    @Nullable
    private Date createdAt;

    @UpdateTimestamp
    @Nullable
    private Date updatedAt;

    public ProductVariant() {
        super();
    }

    public ProductVariant(Long id, String sku) {
        super();
        this.id = id;
        this.sku = sku;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getPrimaryImage() {
        return primaryImage;
    }

    public void setPrimaryImage(String primaryImage) {
        this.primaryImage = primaryImage;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public List<ProductVendor> getCatalogVendors() {
        return catalogVendors;
    }

    public void setCatalogVendors(List<ProductVendor> catalogVendors) {
        this.catalogVendors = catalogVendors;
    }

    public void setUpdatedAt(Date updateAt) {
        this.updatedAt = updateAt;
    }

    @Override
    public String toString() {
        return "Catalog => name:" + longName;
    }
}

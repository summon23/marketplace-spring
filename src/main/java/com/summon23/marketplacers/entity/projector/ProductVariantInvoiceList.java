package com.summon23.marketplacers.entity.projector;

import java.io.Serializable;

/**
 * Projection Class based
 * on Custructor
 */
public class ProductVariantInvoiceList implements Serializable {
    private String sku;
    private String primaryImage;

    public ProductVariantInvoiceList(String sku, String primaryImage) {
        this.sku = sku;
        this.primaryImage = primaryImage;
    }

    public String getSku() {
        return sku;
    }

    public String getPrimaryImage() {
        return primaryImage;
    }

}

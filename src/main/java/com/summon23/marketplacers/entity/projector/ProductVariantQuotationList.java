package com.summon23.marketplacers.entity.projector;

import java.io.Serializable;
import java.util.Map;

public class ProductVariantQuotationList implements Serializable {

    private String sku;
    private String longName;
    private String primaryImage;

    public ProductVariantQuotationList(Map<String, Object> response) {
        this.sku = response.get("sku") != null ? (String) response.get("sku") : null;
        this.longName = response.get("longName") != null ? (String) response.get("longName") : null;
        this.primaryImage = response.get("primaryImage") != null ? (String) response.get("primaryImage") : null;
    }

    public String getSku() {
        return sku;
    }

    public String getLongName() {
        return longName;
    }

    public String getPrimaryImage() {
        return primaryImage;
    }
}

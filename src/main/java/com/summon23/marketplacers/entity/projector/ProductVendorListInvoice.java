package com.summon23.marketplacers.entity.projector;

import org.springframework.beans.factory.annotation.Value;

/**
 * Close Projection
 * Just Add Getter in this class to project the JPA
 */
public interface ProductVendorListInvoice {
    Long getId();

    String getCurrency();

    String getVendorId();
}

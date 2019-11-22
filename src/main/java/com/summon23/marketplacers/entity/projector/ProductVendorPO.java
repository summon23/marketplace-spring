package com.summon23.marketplacers.entity.projector;

import org.springframework.beans.factory.annotation.Value;

/**
 * Open Projection
 */
public interface ProductVendorPO {

    Long getId();

    String getVendorId();

    String getCurrency();

//    @Value("#{target.currency} #{target.id}")
//    String getPrice();
}

package com.summon23.marketplacers.service;

import com.summon23.marketplacers.entity.ProductVariant;

public interface ProductVariantService {
    void updateName(Long catalogId, String newName);
}

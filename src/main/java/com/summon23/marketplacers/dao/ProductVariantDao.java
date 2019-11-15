package com.summon23.marketplacers.dao;

import com.summon23.marketplacers.entity.ProductVariant;

public interface ProductVariantDao {
    void updateName(Long catalogId, String newName);
}

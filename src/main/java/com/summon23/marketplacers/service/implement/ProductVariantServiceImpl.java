package com.summon23.marketplacers.service.implement;

import com.summon23.marketplacers.dao.ProductVariantDao;
import com.summon23.marketplacers.entity.ProductVariant;
import com.summon23.marketplacers.service.ProductVariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductVariantServiceImpl implements ProductVariantService {

    @Autowired
    ProductVariantDao productVariantDao;

    @Override
    public void updateName(Long catalogId, String newName) {
        productVariantDao.updateName(catalogId, newName);
    }
}

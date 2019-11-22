package com.summon23.marketplacers.service;

import com.summon23.marketplacers.entity.projector.ProductVariantInvoiceList;
import com.summon23.marketplacers.repository.ProductVariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductVariantService {

    @Autowired
    private ProductVariantRepository productVariantRepository;

    public List<ProductVariantInvoiceList> getProductVariantInvoiceList() {
        return productVariantRepository.findAllInvoiceList();
    }
}

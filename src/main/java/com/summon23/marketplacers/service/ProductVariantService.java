package com.summon23.marketplacers.service;

import com.summon23.marketplacers.entity.projector.ProductVariantInvoiceList;
import com.summon23.marketplacers.entity.projector.ProductVariantQuotationList;
import com.summon23.marketplacers.repository.ProductVariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductVariantService {

    @Autowired
    private ProductVariantRepository productVariantRepository;

    public List<ProductVariantInvoiceList> getProductVariantInvoiceList() {
        return productVariantRepository.findAllInvoiceList();
    }

    public List<ProductVariantQuotationList> getProductVariantQuotation() {
        List<Map<String, Object>> getDataProduct = productVariantRepository.findAllQuotationProduct();
        return getDataProduct.stream().map(ProductVariantQuotationList::new).collect(Collectors.toList());


    }
}

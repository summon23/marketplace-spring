package com.summon23.marketplacers.service;


import com.summon23.marketplacers.entity.ProductVendor;
import com.summon23.marketplacers.repository.ProductVendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Component
@Service
public class ProductVendorService {

    @Autowired
    private ProductVendorRepository productVendorRepository;

    public ProductVendorService(ProductVendorRepository productVendorRepository) {
        this.productVendorRepository = productVendorRepository;
    }


    @Transactional
    public void updateCurrency(String newCurrency, Long productVendorId) {
        ProductVendor existProduct = productVendorRepository.findById(productVendorId).orElseThrow(() -> new RuntimeException("PRODUCT NOT FOUND"));

        existProduct.setCurrency(newCurrency);
        productVendorRepository.save(existProduct);

        if (newCurrency.equals("SGD")) throw new RuntimeException("CURRENCY ERROR");
    }
}

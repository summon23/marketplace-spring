package com.summon23.marketplacers.controller;

import com.summon23.marketplacers.service.ProductVariantService;
import com.summon23.marketplacers.service.ProductVendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("catalog")
public class CatalogController {

    @Autowired
    private final ProductVariantService productVariantService;

    @Autowired
    private final ProductVendorService productVendorService;

    public CatalogController(ProductVariantService productVariantService, ProductVendorService productVendorService) {
        this.productVariantService = productVariantService;
        this.productVendorService = productVendorService;
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateCatalog(
            @PathVariable(value = "id") Long catalogId,
            @RequestBody Map<String, String> newCatalog) {

        String newLongName = newCatalog.get("long_name");
        productVariantService.updateName(catalogId, newLongName);

        return ResponseEntity.ok().build();
    }

    @Transactional
    @PutMapping("vendor/{id}")
    public ResponseEntity<?> updateCatalogVendor(
            @PathVariable(value = "id") Long catalogId,
            @RequestBody Map<String, String> newCatalog) {

        String newCurrency = newCatalog.get("long_name");

        productVendorService.updateCurrency(newCurrency, catalogId);

        return ResponseEntity.ok().build();
    }


}

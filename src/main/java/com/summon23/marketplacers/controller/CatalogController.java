package com.summon23.marketplacers.controller;

import com.summon23.marketplacers.service.ProductVariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("catalog")
public class CatalogController {

    @Autowired
    private final ProductVariantService productVariantService;

    public CatalogController(ProductVariantService productVariantService) {
        this.productVariantService = productVariantService;
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateCatalog(
            @PathVariable(value = "id") Long catalogId,
            @RequestBody Map<String, String> newCatalog) {

        String newLongName = newCatalog.get("long_name");
        productVariantService.updateName(catalogId, newLongName);

        return ResponseEntity.ok().build();
    }
}

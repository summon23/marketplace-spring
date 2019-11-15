package com.summon23.marketplacers.controller;

import com.summon23.marketplacers.entity.ProductVariant;
import com.summon23.marketplacers.entity.ProductVendor;
import com.summon23.marketplacers.repository.ProductVariantRepository;
import com.summon23.marketplacers.repository.ProductVendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Map;

@RestController
@RequestMapping("catalog")
public class CatalogController {

    @Autowired
    private final ProductVariantRepository productVariantRepository;

    @Autowired
    private final ProductVendorRepository productVendorRepository;

    public CatalogController(ProductVariantRepository productVariantRepository, ProductVendorRepository productVendorRepository) {
        this.productVariantRepository = productVariantRepository;
        this.productVendorRepository = productVendorRepository;
    }

    @Transactional
    @PutMapping("/vendor/{id}")
    public ResponseEntity<?> updateCatalog(
            @PathVariable(value = "id") Long catalogId,
            @RequestBody Map<String, String> newCatalog) {

        String newLongName = newCatalog.get("long_name");
        ProductVendor pv =  productVendorRepository.findById(catalogId).orElseThrow(() -> new RuntimeException("NOT FOUND"));

        pv.setCurrency(newLongName);
        productVendorRepository.save(pv);

        ProductVariant pVar = productVariantRepository.findById(new Long(2)).orElseThrow(() -> new RuntimeException("NOT FOUND"));
        pVar.setLongName("NEW SKU");
        productVariantRepository.save(pVar);

        if (newLongName.equals("USD")) throw new RuntimeException("ROLLBACK");

        return ResponseEntity.ok().build();
    }

//    @PostMapping("/vendor")
//    public ResponseEntity<?> insertProductVendor() {
//        ProductVendor newProduct = new ProductVendor( new Long(112233));
//        productVendorService.insertProductVendor(newProduct);
//
//        return ResponseEntity.ok().build();
//    }
}

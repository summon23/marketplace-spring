package com.summon23.marketplacers.controller;

import com.summon23.marketplacers.entity.ProductVariant;
import com.summon23.marketplacers.entity.ProductVendor;
import com.summon23.marketplacers.entity.projector.ProductVariantInvoiceList;
import com.summon23.marketplacers.entity.projector.ProductVariantQuotationList;
import com.summon23.marketplacers.entity.projector.ProductVendorListInvoice;
import com.summon23.marketplacers.entity.projector.ProductVendorPO;
import com.summon23.marketplacers.repository.ProductVariantRepository;
import com.summon23.marketplacers.repository.ProductVendorRepository;
import com.summon23.marketplacers.service.ProductVariantService;
import com.summon23.marketplacers.service.ProductVendorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("catalog")
public class CatalogController {

    private final static Logger logger = LoggerFactory.getLogger(CatalogController.class);

    @Autowired
    private final ProductVariantRepository productVariantRepository;

    @Autowired
    private final ProductVendorRepository productVendorRepository;

    @Autowired
    private ProductVendorService productVendorService;

    @Autowired
    private ProductVariantService productVariantService;

    public CatalogController(ProductVariantRepository productVariantRepository, ProductVendorRepository productVendorRepository) {
        this.productVariantRepository = productVariantRepository;
        this.productVendorRepository = productVendorRepository;
    }

    @GetMapping
    public ResponseEntity<List<ProductVendor>> getProductVariant(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortOrder
    ) {
        List<ProductVendor> listCatalogVendor = productVendorService.findAllPaginated(pageNo, pageSize, sortBy, sortOrder);

        return new ResponseEntity<List<ProductVendor>>(listCatalogVendor, new HttpHeaders(), HttpStatus.OK);
    }

    @Transactional
    @PutMapping("/vendor/{id}")
    public ResponseEntity<?> updateCatalog(
            @PathVariable(value = "id") Long catalogId,
            @RequestBody Map<String, String> newCatalog) {

        String newLongName = newCatalog.get("long_name");
        ProductVendor pv =  productVendorService.findById(catalogId);

        pv.setCurrency(newLongName);
        productVendorRepository.save(pv);

        ProductVariant pVar = productVariantRepository.findById(new Long(2)).orElseThrow(() -> new RuntimeException("NOT FOUND"));
        pVar.setLongName("NEW SKU");
        productVariantRepository.save(pVar);

        if (newLongName.equals("USD")) {
            logger.info("THROW");
            throw new RuntimeException("ROLLBACK");
        }

        logger.info("Success");

        return ResponseEntity.ok().build();
    }

    @GetMapping("/currency/{curr}")
    public ResponseEntity<List<ProductVendorListInvoice>> getSampleWithCloseProjection (
            @PathVariable(value = "curr") String currency
    ) {
        List<ProductVendorListInvoice> getDataProduct = productVendorService.getAllByCloseProjection(currency);

        return new ResponseEntity<List<ProductVendorListInvoice>>(getDataProduct, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/variant/{variantid}")
    public ResponseEntity<List<ProductVendorPO>> getSampleWithOpenProjection (
            @PathVariable(value = "variantid") Integer variantId
    ) {
        // List<ProductVendorPO> getDataProduct = productVendorService.getAllByOpenProjection(variantId);
        List<ProductVendorPO> getDataProduct = productVendorService.getAllByDynamicProjection(variantId);

        return new ResponseEntity<List<ProductVendorPO>>(getDataProduct, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/variant/invoice")
    public ResponseEntity<List<ProductVariantInvoiceList>> getProductVariantForInvoice(
            @RequestBody Map<String, String> bodyPayload
    ) {
        List<ProductVariantInvoiceList> getProductInvoiceList= productVariantService.getProductVariantInvoiceList();
        return new ResponseEntity<List<ProductVariantInvoiceList>>(getProductInvoiceList, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/variant/quotation")
    public ResponseEntity<List<ProductVariantQuotationList>> getProductVariantForQuotation(
            @RequestBody Map<String, String> bodyPayload
    ) {
        List<ProductVariantQuotationList> getProductInvoiceList= productVariantService.getProductVariantQuotation();
        return new ResponseEntity<List<ProductVariantQuotationList>>(getProductInvoiceList, new HttpHeaders(), HttpStatus.OK);
    }



}

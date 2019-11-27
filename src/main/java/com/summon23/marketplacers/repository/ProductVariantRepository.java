package com.summon23.marketplacers.repository;

import com.summon23.marketplacers.entity.ProductVariant;
import com.summon23.marketplacers.entity.projector.ProductVariantInvoiceList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public interface ProductVariantRepository extends JpaRepository<ProductVariant, Long> {

    @Query("SELECT new com.summon23.marketplacers.entity.projector.ProductVariantInvoiceList(e.sku, e.primaryImage) FROM ProductVariant e")
    List<ProductVariantInvoiceList> findAllInvoiceList();

    @Query("SELECT e.sku as sku, e.primaryImage as primaryImage, e.longName as longName FROM ProductVariant e")
    List<Map<String, Object>> findAllQuotationProduct();

    <T> List<T> findBySku(String skuID, Class<T> tClass);




}

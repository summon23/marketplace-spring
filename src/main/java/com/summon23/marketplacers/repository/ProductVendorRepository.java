package com.summon23.marketplacers.repository;

import com.summon23.marketplacers.entity.ProductVendor;
import com.summon23.marketplacers.entity.projector.ProductVendorListInvoice;
import com.summon23.marketplacers.entity.projector.ProductVendorPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ProductVendorRepository extends JpaRepository<ProductVendor, Long> {
    List<ProductVendorListInvoice> findByCurrency(String currency);
    List<ProductVendorPO> findByProductVariantId(Integer id);

    <T> List<T> findByProductVariantId(Integer id, Class<T> tClass);
}

package com.summon23.marketplacers.repository;

import com.summon23.marketplacers.entity.ProductVendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProductVendorRepository extends JpaRepository<ProductVendor, Long> {

    @Transactional(timeout = 10)
    @Override
    <S extends ProductVendor> S save(S s);
}

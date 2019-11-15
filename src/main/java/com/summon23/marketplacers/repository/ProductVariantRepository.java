package com.summon23.marketplacers.repository;

import com.summon23.marketplacers.entity.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ProductVariantRepository extends JpaRepository<ProductVariant, Long> {
}

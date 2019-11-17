package com.summon23.marketplacers.service;

import com.summon23.marketplacers.entity.ProductVendor;
import com.summon23.marketplacers.exception.CatalogNotFoundException;
import com.summon23.marketplacers.repository.ProductVendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductVendorService {

    @Autowired
    private ProductVendorRepository productVendorRepository;

    public ProductVendor findById(Long id) {
        return productVendorRepository.findById(id).orElseThrow(() -> new RuntimeException("NOT FOUND"));
    }

    public List<ProductVendor> findAllPaginated (Integer pageNo, Integer pageSize, String sortBy, String sortOrder) {
        Sort.Direction sortDirection =  sortOrder.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortDirection, sortBy));

        Page<ProductVendor> pagedResult = productVendorRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ProductVendor>();
        }
    }


}

package com.summon23.marketplacers.lib;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class Libx {

    public static Pageable generatePage (Integer pageNo, Integer pageSize, String sortBy, String sortOrder) {
        Sort.Direction sortDirection =  sortOrder.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortDirection, sortBy));
        return paging;
    }
}

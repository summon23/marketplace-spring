package com.summon23.marketplacers.exception;

public class CatalogNotFoundException extends Exception {
    private Long catalogId;

    public CatalogNotFoundException(Long catalogId) {
        super(String.format("Catalog is not found with id : '%s'", catalogId));
    }
}

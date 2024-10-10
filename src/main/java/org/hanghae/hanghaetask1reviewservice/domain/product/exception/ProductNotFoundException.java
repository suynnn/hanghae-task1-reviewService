package org.hanghae.hanghaetask1reviewservice.domain.product.exception;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(String message) {
        super(message);
    }
}

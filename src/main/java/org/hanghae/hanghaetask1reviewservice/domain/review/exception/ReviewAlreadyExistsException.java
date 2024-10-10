package org.hanghae.hanghaetask1reviewservice.domain.review.exception;

public class ReviewAlreadyExistsException extends RuntimeException{

    public ReviewAlreadyExistsException(String message) {
        super(message);
    }
}

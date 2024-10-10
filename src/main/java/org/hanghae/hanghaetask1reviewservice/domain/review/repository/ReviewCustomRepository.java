package org.hanghae.hanghaetask1reviewservice.domain.review.repository;

import org.hanghae.hanghaetask1reviewservice.domain.review.entity.Review;
import org.springframework.data.domain.Slice;

public interface ReviewCustomRepository {
    Slice<Review> findReviewsByProductId(Long productId, Long cursor, int size);
}

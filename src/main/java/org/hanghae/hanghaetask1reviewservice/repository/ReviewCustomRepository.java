package org.hanghae.hanghaetask1reviewservice.repository;

import org.hanghae.hanghaetask1reviewservice.entity.Review;
import org.springframework.data.domain.Slice;

public interface ReviewCustomRepository {
    Slice<Review> findReviewsByProductId(Long productId, Long cursor, int size);
}

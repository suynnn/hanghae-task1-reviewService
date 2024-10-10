package org.hanghae.hanghaetask1reviewservice.domain.review.repository;

import org.hanghae.hanghaetask1reviewservice.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewCustomRepository {

    Boolean existsReviewByProductIdAndUserId(Long productId, Long userId);
}

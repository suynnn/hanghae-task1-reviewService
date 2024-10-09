package org.hanghae.hanghaetask1reviewservice.repository;

import org.hanghae.hanghaetask1reviewservice.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewCustomRepository {
}

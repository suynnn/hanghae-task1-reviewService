package org.hanghae.hanghaetask1reviewservice.domain.product.dto;

import lombok.Getter;
import lombok.Setter;
import org.hanghae.hanghaetask1reviewservice.domain.review.dto.ReviewRespDto;
import org.hanghae.hanghaetask1reviewservice.domain.product.entity.Product;
import org.hanghae.hanghaetask1reviewservice.domain.review.entity.Review;

import java.util.List;

@Getter
@Setter
public class ProductRespDto {
    private Long totalCount;
    private Float score;
    private Long cursor;
    private List<ReviewRespDto> reviews;

    public ProductRespDto(Product product, long cursor, List<Review> reviews) {
        this.totalCount = product.getReviewCount();
        this.score = product.getScore();
        this.cursor = cursor;
        this.reviews = reviews.stream().map(ReviewRespDto::new).toList();
    }
}

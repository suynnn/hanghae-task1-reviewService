package org.hanghae.hanghaetask1reviewservice.domain.product.service;

import lombok.RequiredArgsConstructor;
import org.hanghae.hanghaetask1reviewservice.domain.product.dto.ProductRespDto;
import org.hanghae.hanghaetask1reviewservice.domain.product.entity.Product;
import org.hanghae.hanghaetask1reviewservice.domain.review.entity.Review;
import org.hanghae.hanghaetask1reviewservice.domain.product.repository.ProductRepository;
import org.hanghae.hanghaetask1reviewservice.domain.review.repository.ReviewRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;

    public ProductRespDto findProductByProductId(long productId, long cursor, int size) {

        Product product = productRepository.findById(productId).orElseThrow();
        List<Review> reviewList = reviewRepository.findReviewsByProductId(productId, cursor, size).getContent();

        return new ProductRespDto(product, cursor, reviewList);
    }
}

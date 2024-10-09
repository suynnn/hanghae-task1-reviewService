package org.hanghae.hanghaetask1reviewservice.service;

import lombok.RequiredArgsConstructor;
import org.hanghae.hanghaetask1reviewservice.dto.ProductRespDto;
import org.hanghae.hanghaetask1reviewservice.entity.Product;
import org.hanghae.hanghaetask1reviewservice.entity.Review;
import org.hanghae.hanghaetask1reviewservice.repository.ProductRepository;
import org.hanghae.hanghaetask1reviewservice.repository.ReviewRepository;
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

package org.hanghae.hanghaetask1reviewservice.domain.review.service;

import lombok.RequiredArgsConstructor;
import org.hanghae.hanghaetask1reviewservice.common.s3.S3Service;
import org.hanghae.hanghaetask1reviewservice.common.user.entity.User;
import org.hanghae.hanghaetask1reviewservice.common.user.repository.UserRepository;
import org.hanghae.hanghaetask1reviewservice.domain.product.entity.Product;
import org.hanghae.hanghaetask1reviewservice.domain.product.exception.ProductNotFoundException;
import org.hanghae.hanghaetask1reviewservice.domain.product.repository.ProductRepository;
import org.hanghae.hanghaetask1reviewservice.domain.review.dto.ReviewReqDto;
import org.hanghae.hanghaetask1reviewservice.domain.review.entity.Review;
import org.hanghae.hanghaetask1reviewservice.domain.review.exception.ReviewAlreadyExistsException;
import org.hanghae.hanghaetask1reviewservice.domain.review.repository.ReviewRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    private final S3Service s3Service;

    @Transactional(readOnly = false)
    public void saveReview(MultipartFile imageFile, ReviewReqDto reviewReqDto, Long productId) {

        Boolean isReviewExists = reviewRepository.existsReviewByProductIdAndUserId(productId, reviewReqDto.getUserId());

        if (isReviewExists) {
            throw new ReviewAlreadyExistsException("해당 상품에 대한 리뷰는 이미 작성한 상태입니다. 더 이상 작성하실 수 없습니다.");
        }

        Product product = productRepository.findByIdWithLock(productId).orElseThrow(() -> new ProductNotFoundException("해당 productId에 해당하는 Product를 찾을 수 없습니다."));
        User user = userRepository.findById(reviewReqDto.getUserId()).orElseThrow();

        String imageUrl = s3Service.uploadFile(imageFile);

        Review review = new Review();
        review.publishReview(reviewReqDto, imageUrl, product, user);
        reviewRepository.save(review);

        product.updateProduct(review.getScore());
    }
}

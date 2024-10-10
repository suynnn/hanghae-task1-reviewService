package org.hanghae.hanghaetask1reviewservice.domain.product.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hanghae.hanghaetask1reviewservice.domain.product.dto.ProductRespDto;
import org.hanghae.hanghaetask1reviewservice.domain.product.service.ProductService;
import org.hanghae.hanghaetask1reviewservice.domain.review.dto.ReviewReqDto;
import org.hanghae.hanghaetask1reviewservice.domain.review.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ReviewService reviewService;

    @GetMapping("/{productId}/reviews")
    public ResponseEntity<ProductRespDto> productFindByProductId(@PathVariable("productId") Long productId,
                                                                 @RequestParam("cursor") Long cursor,
                                                                 @RequestParam(value = "size", defaultValue = "10") int size) {

        return ResponseEntity.ok(productService.findProductByProductId(productId, cursor, size));
    }

    @PostMapping("/{productId}/reviews")
    public ResponseEntity<Void> productReviewSave(@PathVariable("productId") Long productId,
                                                  @RequestPart("image") MultipartFile imageFile,
                                                  @Valid @RequestPart("review") ReviewReqDto reviewReqDto) {

        reviewService.saveReview(imageFile, reviewReqDto, productId);

        return ResponseEntity.ok().build();
    }
}

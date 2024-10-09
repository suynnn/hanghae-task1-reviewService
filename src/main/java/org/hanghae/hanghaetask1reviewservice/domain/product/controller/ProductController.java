package org.hanghae.hanghaetask1reviewservice.domain.product.controller;

import lombok.RequiredArgsConstructor;
import org.hanghae.hanghaetask1reviewservice.domain.product.dto.ProductRespDto;
import org.hanghae.hanghaetask1reviewservice.domain.product.service.ProductService;
import org.hanghae.hanghaetask1reviewservice.domain.review.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ReviewService reviewService;

    @GetMapping("/{productId}/reviews")
    public ResponseEntity<ProductRespDto> ProductFindByProductId(@PathVariable("productId") Long productId,
                                                                 @RequestParam("cursor") Long cursor,
                                                                 @RequestParam(value = "size", defaultValue = "10") int size) {

        return ResponseEntity.ok(productService.findProductByProductId(productId, cursor, size));
    }
}

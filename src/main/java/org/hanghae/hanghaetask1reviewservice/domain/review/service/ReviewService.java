package org.hanghae.hanghaetask1reviewservice.domain.review.service;

import lombok.RequiredArgsConstructor;
import org.hanghae.hanghaetask1reviewservice.domain.review.repository.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
}

package org.hanghae.hanghaetask1reviewservice.service;

import lombok.RequiredArgsConstructor;
import org.hanghae.hanghaetask1reviewservice.repository.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
}

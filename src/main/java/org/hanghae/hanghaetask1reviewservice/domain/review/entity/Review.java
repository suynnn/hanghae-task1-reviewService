package org.hanghae.hanghaetask1reviewservice.domain.review.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hanghae.hanghaetask1reviewservice.domain.product.entity.Product;
import org.hanghae.hanghaetask1reviewservice.common.user.entity.User;
import org.hanghae.hanghaetask1reviewservice.domain.review.dto.ReviewReqDto;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"product_id", "user_id"})
}, indexes = @Index(name = "idx_review_product_id_created_at_review_id", columnList = "product_id, created_at, review_id"))
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    @Column(nullable = false)
    private Integer score;

    @Column(nullable = false, columnDefinition = "varchar(255)")
    private String content;

    @Column(columnDefinition = "varchar(255)")
    private String imageUrl;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="user_id", nullable = false)
    private User user;

    public void publishReview(ReviewReqDto reviewReqDto, String imageUrl, Product product, User user) {
        this.score = reviewReqDto.getScore();
        this.content = reviewReqDto.getContent();
        this.imageUrl = imageUrl;
        this.createdAt = LocalDateTime.now();
        this.product = product;
        this.user = user;
    }
}

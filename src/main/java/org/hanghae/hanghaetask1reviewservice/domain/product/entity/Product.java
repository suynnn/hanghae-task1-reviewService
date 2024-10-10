package org.hanghae.hanghaetask1reviewservice.domain.product.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table
@Getter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(nullable = false)
    private Long reviewCount;

    @Column(nullable = false)
    private Float score;

    public void updateProduct(int newScore) {

        Float sumScore = this.score * reviewCount;

        reviewCount += 1;
        sumScore += newScore;

        float updatedScore = sumScore / reviewCount;
        this.score = Math.round(updatedScore * 100) / 100f;

    }
}

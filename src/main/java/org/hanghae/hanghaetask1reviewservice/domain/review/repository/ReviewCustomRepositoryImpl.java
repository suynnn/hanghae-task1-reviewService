package org.hanghae.hanghaetask1reviewservice.domain.review.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.hanghae.hanghaetask1reviewservice.domain.review.entity.QReview;
import org.hanghae.hanghaetask1reviewservice.domain.review.entity.Review;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewCustomRepositoryImpl implements ReviewCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Slice<Review> findReviewsByProductId(Long productId, Long cursor, int size) {

        QReview review = QReview.review;

        List<Review> results = jpaQueryFactory
                .select(
                        Projections.constructor(
                                Review.class,
                                review.id,
                                review.score,
                                review.content,
                                review.imageUrl,
                                review.createdAt,
                                review.product,
                                review.user ))
                .from(review)
                .where(
                        review.product.id.eq(productId)
                                .and(eqCursor(review, cursor))
                )
                .orderBy(review.createdAt.desc())
                .limit(size)
                .fetch();

        boolean hasNext = false;
        if (results.size() > size) {
            results.remove(size);
            hasNext = true;
        }

        return new SliceImpl<>(results, PageRequest.of(0, size), hasNext);
    }

    private BooleanExpression eqCursor(QReview review, Long cursor) {
        if (cursor != null) {
            return review.id.gt(cursor);
        }
        return null;
    }
}

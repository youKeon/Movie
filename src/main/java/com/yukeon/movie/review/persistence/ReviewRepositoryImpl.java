package com.yukeon.movie.review.persistence;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.yukeon.movie.review.domain.Review;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import static com.yukeon.movie.review.domain.QReview.review;


@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewCustomRepository{
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Review> findReviewList(Long movieId, Float rating) {
        BooleanBuilder builder = new BooleanBuilder();

        builder.and(review.movie.id.eq(movieId));
        Optional.ofNullable(rating).ifPresent(value -> builder.and(review.rating.goe(rating)));

        return jpaQueryFactory.selectFrom(review)
                .where(builder)
                .orderBy(review.createdAt.desc())
                .fetch();
    }
}

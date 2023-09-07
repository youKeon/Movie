package com.yukeon.movie.review.persistence;

import com.yukeon.movie.review.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewCustomRepository {
    List<Review> findReviewList(Long movieId, Float rating);
}

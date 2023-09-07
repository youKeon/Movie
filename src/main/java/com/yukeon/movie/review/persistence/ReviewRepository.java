package com.yukeon.movie.review.persistence;

import com.yukeon.movie.review.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewCustomRepository{
}

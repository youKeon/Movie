package com.yukeon.movie.review.dto.response;

import com.yukeon.movie.review.domain.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ReviewInfoResponse {
    private String content;
    private float rating;
    private LocalDateTime createdAt;

    public static ReviewInfoResponse from(Review review) {
        return new ReviewInfoResponse(
                review.getContent(),
                review.getRating(),
                review.getCreatedAt());
    }
}

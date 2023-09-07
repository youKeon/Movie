package com.yukeon.movie.review.dto.request;

import com.yukeon.movie.movie.domain.Movie;
import com.yukeon.movie.review.domain.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class ReviewSaveRequest {
    @NotNull(message = "공백일 수 없습니다.")
    private Long movieId;

    @NotBlank(message = "공백일 수 없습니다.")
    private String content;

    @Max(5) @Min(0)
    private Float rating;

    public Review toEntity(Movie movie) {
        return new Review(content, rating, movie);
    }
}

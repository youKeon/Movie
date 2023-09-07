package com.yukeon.movie.review.dto.response;

import com.yukeon.movie.movie.domain.Genre;
import com.yukeon.movie.movie.domain.Movie;
import com.yukeon.movie.movie.dto.response.MovieInfoResponse;
import com.yukeon.movie.movie.dto.response.MovieListResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ReviewListResponse {
    private String movieTitle;
    List<ReviewInfoResponse> reviewList;

    public static ReviewListResponse of(Movie movie,
                                        List<ReviewInfoResponse> reviewList) {
        return new ReviewListResponse(movie.getTitle(), reviewList);
    }
}

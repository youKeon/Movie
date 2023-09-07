package com.yukeon.movie.movie.dto.response;

import com.yukeon.movie.movie.domain.Genre;
import com.yukeon.movie.movie.domain.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class MovieInfoResponse {
    private String title;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public static MovieInfoResponse from(Movie movie) {
        return new MovieInfoResponse(
                movie.getTitle(),
                movie.getStartDate(),
                movie.getEndDate());
    }
}

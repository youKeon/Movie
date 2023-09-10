package com.yukeon.movie.movie.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import com.yukeon.movie.movie.domain.Genre;
import com.yukeon.movie.movie.domain.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class MovieInfoResponse {
    private String title;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @QueryProjection
    public MovieInfoResponse(String title,
                             LocalDateTime startDate,
                             LocalDateTime endDate) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static MovieInfoResponse from(Movie movie) {
        return new MovieInfoResponse(
                movie.getTitle(),
                movie.getStartDate(),
                movie.getEndDate());
    }
}

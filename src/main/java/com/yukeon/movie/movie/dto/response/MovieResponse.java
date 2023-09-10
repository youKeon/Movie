package com.yukeon.movie.movie.dto.response;
import com.querydsl.core.annotations.QueryProjection;
import com.yukeon.movie.movie.domain.Genre;
import com.yukeon.movie.movie.domain.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MovieResponse {
    private String title;
    private Genre genre;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Boolean isShowing;

    @QueryProjection
    public MovieResponse(String title,
                         Genre genre,
                         LocalDateTime startDate,
                         LocalDateTime endDate,
                         Boolean isShowing) {
        this.title = title;
        this.genre = genre;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isShowing = isShowing;
    }

    public static MovieResponse from(Movie movie) {
        return new MovieResponse(
                movie.getTitle(),
                movie.getGenre(),
                movie.getStartDate(),
                movie.getEndDate(),
                movie.getIsShowing()
        );
    }
}

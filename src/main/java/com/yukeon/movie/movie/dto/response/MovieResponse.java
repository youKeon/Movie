package com.yukeon.movie.movie.dto.response;
import com.yukeon.movie.movie.domain.Genre;
import com.yukeon.movie.movie.domain.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class MovieResponse {
    private String title;
    private Genre genre;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Boolean isShowing;

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

package com.yukeon.movie.movie.dto.response;
import com.querydsl.core.annotations.QueryProjection;
import com.yukeon.movie.movie.domain.Genre;
import com.yukeon.movie.movie.domain.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class MovieListResponse {
    private Genre genre;
    private Boolean isShowing;
    private List<MovieInfoResponse> infoList;
    @QueryProjection
    public MovieListResponse(Genre genre,
                             Boolean isShowing,
                             List<MovieInfoResponse> infoList) {
        this.genre = genre;
        this.isShowing = isShowing;
        this.infoList = infoList;
    }

    public static MovieListResponse of(Genre genre,
                                       Boolean isShowing,
                                       List<MovieInfoResponse> infoList) {
        return new MovieListResponse(genre, isShowing, infoList);
    }
}

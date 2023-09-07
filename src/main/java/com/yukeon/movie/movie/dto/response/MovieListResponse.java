package com.yukeon.movie.movie.dto.response;
import com.yukeon.movie.movie.domain.Genre;
import com.yukeon.movie.movie.domain.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class MovieListResponse {
    private Genre genre;
    private Boolean isShowing;
    private List<MovieInfoResponse> infoList;

    public static MovieListResponse of(Genre genre,
                                       Boolean isShowing,
                                       List<MovieInfoResponse> infoList) {
        return new MovieListResponse(genre, isShowing, infoList);
    }
}

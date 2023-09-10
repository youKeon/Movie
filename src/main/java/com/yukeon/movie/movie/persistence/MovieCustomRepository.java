package com.yukeon.movie.movie.persistence;

import com.yukeon.movie.movie.domain.Genre;
import com.yukeon.movie.movie.domain.Movie;
import com.yukeon.movie.movie.dto.response.MovieInfoResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface MovieCustomRepository {
    List<MovieInfoResponse> findMovieList(Genre genre, Boolean isShowing, Pageable pageable);
    Optional<Movie> findMovie(Long id);
}

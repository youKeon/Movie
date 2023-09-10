package com.yukeon.movie.movie.application;

import com.yukeon.movie.movie.domain.Genre;
import com.yukeon.movie.movie.domain.Movie;
import com.yukeon.movie.movie.dto.request.MovieSaveRequest;
import com.yukeon.movie.movie.dto.request.MovieUpdateRequest;
import com.yukeon.movie.movie.dto.response.MovieInfoResponse;
import com.yukeon.movie.movie.dto.response.MovieListResponse;
import com.yukeon.movie.movie.dto.response.MovieResponse;
import com.yukeon.movie.movie.exception.NoSuchMovieException;
import com.yukeon.movie.movie.persistence.MovieRepository;
import com.yukeon.movie.review.application.ReviewService;
import com.yukeon.movie.review.dto.response.ReviewInfoResponse;
import com.yukeon.movie.review.dto.response.ReviewListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final ReviewService reviewService;
    public void save(MovieSaveRequest request) {
        movieRepository.save(request.toEntity());
    }

    public MovieResponse find(Long id) {
        Movie movie = movieRepository.findMovie(id).orElseThrow(NoSuchMovieException::new);
        return MovieResponse.from(movie);
    }

    public void update(Long id, MovieUpdateRequest request) {
        Movie movie = movieRepository.findMovie(id).orElseThrow(NoSuchMovieException::new);
        movie.update(request);
    }

    public void delete(Long id) {
        Movie movie = movieRepository.findMovie(id).orElseThrow(NoSuchMovieException::new);
        movie.delete();
    }

    public MovieListResponse findAll(Genre genre, Boolean isShowing, Pageable pageable) {
        List<MovieInfoResponse> infoList = movieRepository.findMovieList(genre, isShowing, pageable);
        return MovieListResponse.of(genre, isShowing, infoList);
    }

    public ReviewListResponse findAllReview(Long id, Float rating) {
        Movie movie = movieRepository.findMovie(id).orElseThrow(NoSuchMovieException::new);
        List<ReviewInfoResponse> reviewList = reviewService.findAll(movie, rating);
        return ReviewListResponse.of(movie, reviewList);
    }
}

package com.yukeon.movie.review.application;

import com.yukeon.movie.movie.application.MovieService;
import com.yukeon.movie.movie.domain.Movie;
import com.yukeon.movie.movie.exception.NoSuchMovieException;
import com.yukeon.movie.movie.persistence.MovieRepository;
import com.yukeon.movie.review.domain.Review;
import com.yukeon.movie.review.dto.request.ReviewSaveRequest;
import com.yukeon.movie.review.dto.response.ReviewInfoResponse;
import com.yukeon.movie.review.persistence.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;
    public void save(ReviewSaveRequest request) {
        Movie movie = movieRepository.findById(request.getMovieId()).orElseThrow(NoSuchMovieException::new);
        reviewRepository.save(request.toEntity(movie));
    }

    public List<ReviewInfoResponse> findAll(Movie movie, Float rating) {
        List<Review> reviewList = reviewRepository.findReviewList(movie.getId(), rating);
        return reviewList.stream()
                .map(ReviewInfoResponse::from)
                .collect(Collectors.toList());
    }
}

package com.yukeon.movie.review.presentation;

import com.yukeon.movie.movie.domain.Genre;
import com.yukeon.movie.movie.dto.request.MovieSaveRequest;
import com.yukeon.movie.movie.dto.response.MovieListResponse;
import com.yukeon.movie.review.application.ReviewService;
import com.yukeon.movie.review.dto.request.ReviewSaveRequest;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @Operation(summary = "리뷰 등록")
    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Valid ReviewSaveRequest request) {
        reviewService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

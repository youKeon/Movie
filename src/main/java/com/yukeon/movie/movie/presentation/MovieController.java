package com.yukeon.movie.movie.presentation;

import com.yukeon.movie.movie.application.MovieService;
import com.yukeon.movie.movie.domain.Genre;
import com.yukeon.movie.movie.dto.request.MovieSaveRequest;
import com.yukeon.movie.movie.dto.request.MovieUpdateRequest;
import com.yukeon.movie.movie.dto.response.MovieListResponse;
import com.yukeon.movie.movie.dto.response.MovieResponse;
import com.yukeon.movie.review.dto.response.ReviewListResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/movies")
public class MovieController {

    private final MovieService movieService;

    @Operation(summary = "영화 등록")
    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Valid MovieSaveRequest request) {
        movieService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "영화 단일 조회")
    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> find(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.find(id));
    }

    @Operation(summary = "영화 목록 조회")
    @GetMapping()
    public ResponseEntity<MovieListResponse> findAll(@RequestParam(required = false) Genre genre,
                                                     @RequestParam(required = false) Boolean isShowing,
                                                     Pageable pageable) {
        return ResponseEntity.ok(movieService.findAll(genre, isShowing, pageable));
    }

    @Operation(summary = "영화 댓글 조회")
    @GetMapping("/{id}/reviews")
    public ResponseEntity<ReviewListResponse> findAllReview(@PathVariable Long id,
                                                            @RequestParam(required = false) Float rating) {
        return ResponseEntity.ok(movieService.findAllReview(id, rating));
    }

    @Operation(summary = "영화 수정")
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,
                                       @RequestBody @Valid MovieUpdateRequest request) {
        movieService.update(id, request);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "영화 삭제")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        movieService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

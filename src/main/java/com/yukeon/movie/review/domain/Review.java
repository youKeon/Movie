package com.yukeon.movie.review.domain;

import com.yukeon.movie.common.BaseEntity;
import com.yukeon.movie.movie.domain.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private Float rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public Review(String content,
                  Float rating,
                  Movie movie) {
        this.content = content;
        this.rating = rating;
        this.movie = movie;
    }
}

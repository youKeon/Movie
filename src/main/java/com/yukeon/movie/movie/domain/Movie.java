package com.yukeon.movie.movie.domain;

import com.yukeon.movie.common.BaseEntity;
import com.yukeon.movie.movie.dto.request.MovieUpdateRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity @Getter
@NoArgsConstructor
public class Movie extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private LocalDateTime endDate;

    private LocalDateTime startDate;

    private Boolean isShowing;

    private Boolean isDeleted = false;

    public Movie(String title,
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

    public void update(MovieUpdateRequest request) {
        this.title = request.getTitle();
        this.genre = request.getGenre();
        this.endDate = request.getEndDate();
        this.isShowing = request.getIsShowing();
    }

    public void delete() {
        this.isDeleted = true;
    }
}

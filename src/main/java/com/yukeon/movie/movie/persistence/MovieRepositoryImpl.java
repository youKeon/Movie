package com.yukeon.movie.movie.persistence;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.yukeon.movie.movie.domain.Genre;
import com.yukeon.movie.movie.domain.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static com.yukeon.movie.movie.domain.QMovie.movie;

@RequiredArgsConstructor
public class MovieRepositoryImpl implements MovieCustomRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Movie> findMovieList(Genre genre, Boolean isShowing, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();

        builder.and(movie.isDeleted.isFalse());
        Optional.ofNullable(genre).ifPresent(value -> builder.and(movie.genre.eq(value)));
        Optional.ofNullable(isShowing).ifPresent(value -> builder.and(movie.isShowing.eq(value)));

        return jpaQueryFactory
                .selectFrom(movie)
                .where(builder)
                .orderBy(movie.startDate.asc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    @Override
    public Optional<Movie> findMovie(Long id) {
        return Optional.ofNullable(jpaQueryFactory
                .selectFrom(movie)
                .where(
                        movie.id.eq(id),
                        movie.isDeleted.isFalse()
                )
                .fetchOne());
    }
}

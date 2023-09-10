package com.yukeon.movie.movie.persistence;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.yukeon.movie.movie.domain.Genre;
import com.yukeon.movie.movie.domain.Movie;
import com.yukeon.movie.movie.dto.response.MovieInfoResponse;
import com.yukeon.movie.movie.dto.response.QMovieInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static com.yukeon.movie.movie.domain.QMovie.movie;

@RequiredArgsConstructor
public class MovieRepositoryImpl implements MovieCustomRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<MovieInfoResponse> findMovieList(Genre genre, Boolean isShowing, Pageable pageable) {
        return jpaQueryFactory
                .select(new QMovieInfoResponse(
                        movie.title,
                        movie.startDate,
                        movie.endDate
                ))
                .where(
                        eqGenre(genre),
                        eqIsShowing(isShowing)
                )
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

    private BooleanExpression eqGenre(Genre genre) {
        if (genre == null) return null;
        return movie.genre.eq(genre);
    }

    private BooleanExpression eqIsShowing(Boolean isShowing) {
        return movie.isShowing.eq(isShowing);
    }
}

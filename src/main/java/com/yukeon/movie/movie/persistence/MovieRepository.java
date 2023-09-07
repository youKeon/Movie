package com.yukeon.movie.movie.persistence;

import com.yukeon.movie.movie.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long>, MovieCustomRepository{
}

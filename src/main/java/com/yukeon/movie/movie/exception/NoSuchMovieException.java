package com.yukeon.movie.movie.exception;

public class NoSuchMovieException extends RuntimeException {
    public NoSuchMovieException(final String message) {
        super(message);
    }

    public NoSuchMovieException() {
        this("존재하지 않는 영화입니다.");
    }
}

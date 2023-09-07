package com.yukeon.movie.movie.dto.request;

import com.yukeon.movie.movie.domain.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
@Getter
@AllArgsConstructor
public class MovieUpdateRequest {
    @NotBlank(message = "공백일 수 없습니다.")
    private String title;

    @NotNull(message = "공백일 수 없습니다.")
    private Genre genre;

    @NotNull(message = "공백일 수 없습니다.")
    private LocalDateTime startDate;

    @NotNull(message = "공백일 수 없습니다.")
    private LocalDateTime endDate;

    @NotNull(message = "공백일 수 없습니다.")
    private Boolean isShowing;
}

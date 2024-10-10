package org.hanghae.hanghaetask1reviewservice.domain.review.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewReqDto {

    @NotNull(message = "userId는 필수 값입니다.")
    private Long userId;

    @Min(1)
    @Max(5)
    @NotNull(message = "score는 필수 값입니다.")
    private Integer score;

    @NotNull(message = "content는 필수 값입니다.")
    @Size(min = 1, max = 255, message = "리뷰 내용은 1~ 255글자 사이어야 합니다.")
    private String content;
}

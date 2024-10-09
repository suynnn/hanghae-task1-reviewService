package org.hanghae.hanghaetask1reviewservice.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Getter;
import lombok.Setter;
import org.hanghae.hanghaetask1reviewservice.entity.Review;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReviewRespDto {
    private Long id;
    private Long userId;
    private Integer score;
    private String content;
    private String imageUrl;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime createdAt;

    public ReviewRespDto(Review review) {
        this.id = review.getId();
        this.userId = review.getUser().getId();
        this.score = review.getScore();
        this.content = review.getContent();
        this.imageUrl = review.getImageUrl();
        this.createdAt = review.getCreatedAt();
    }
}

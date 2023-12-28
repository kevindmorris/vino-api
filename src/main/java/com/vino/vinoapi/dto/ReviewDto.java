package com.vino.vinoapi.dto;

import com.vino.vinoapi.model.Review;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewDto {

    private Long id;
    private String description;
    private WineDto wine;

    public static ReviewDto toBasic(Review e) {
        ReviewDto dto = new ReviewDto();
        dto.setId(e.getId());
        dto.setDescription(e.getDescription());
        dto.setWine(WineDto.toBasic(e.getWine()));
        return dto;
    }

}

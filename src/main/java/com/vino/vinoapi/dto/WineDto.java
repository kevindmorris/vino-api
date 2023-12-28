package com.vino.vinoapi.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.vino.vinoapi.enums.WineType;
import com.vino.vinoapi.model.Wine;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(value = Include.NON_NULL)
@Getter
@Setter
public class WineDto {

    private Long id;
    private String name;
    private WineType type;
    private String description;
    private List<ReviewDto> reviews;

    public static WineDto toBasic(Wine e) {
        WineDto dto = new WineDto();
        dto.setId(e.getId());
        dto.setName(e.getName());
        dto.setType(e.getType());
        dto.setDescription(e.getDescription());
        return dto;
    }

    public static WineDto toComplex(Wine e) {
        WineDto dto = new WineDto();
        dto.setId(e.getId());
        dto.setName(e.getName());
        dto.setType(e.getType());
        dto.setDescription(e.getDescription());
        dto.setReviews(e.getReviews().stream().map(ReviewDto::toBasic).collect(Collectors.toList()));
        return dto;
    }

}

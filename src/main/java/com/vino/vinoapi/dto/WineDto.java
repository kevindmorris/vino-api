package com.vino.vinoapi.dto;

import com.vino.vinoapi.enums.WineType;
import com.vino.vinoapi.model.Wine;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WineDto {

    private Long id;
    private String name;
    private WineType type;
    private String description;

    public static WineDto toBasic(Wine e) {
        WineDto dto = new WineDto();
        dto.setId(e.getId());
        dto.setName(e.getName());
        dto.setType(e.getType());
        return dto;
    }

    public static WineDto toComplex(Wine e) {
        WineDto dto = new WineDto();
        dto.setId(e.getId());
        dto.setName(e.getName());
        dto.setType(e.getType());
        dto.setDescription(e.getDescription());
        return dto;
    }

}

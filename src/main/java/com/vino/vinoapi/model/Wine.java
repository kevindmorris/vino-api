package com.vino.vinoapi.model;

import com.vino.vinoapi.enums.WineType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "WINE")
@Entity
@Getter
@Setter
public class Wine {

    @Column(nullable = false)
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private WineType type;

    @Column(nullable = false)
    private String description;

    public Wine() {
    }

    public Wine(String name, WineType type, String description) {
        this.name = name;
        this.type = type;
        this.description = description;
    }

}

package com.vino.vinoapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "REVIEW")
@Entity
@Getter
@Setter
public class Review {

    @Column(nullable = false)
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String description;

    public Review() {
    }

    public Review(String description) {
        this.description = description;
    }

}

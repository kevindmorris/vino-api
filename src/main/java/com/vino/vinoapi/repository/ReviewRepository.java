package com.vino.vinoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vino.vinoapi.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}

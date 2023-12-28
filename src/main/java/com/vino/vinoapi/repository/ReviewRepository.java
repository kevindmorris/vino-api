package com.vino.vinoapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vino.vinoapi.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByWineId(Long wineId);

}

package com.vino.vinoapi.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vino.vinoapi.dto.ReviewDto;
import com.vino.vinoapi.exception.BaseException;
import com.vino.vinoapi.service.ReviewService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@Tag(name = "2. Review Controller", description = "This controller exposes endpoints to manage review content.")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    // POST
    @Operation(summary = "Create a review.")
    @PostMapping("/reviews")
    public ResponseEntity<ReviewDto> createReview(@RequestBody ReviewDto e) throws BaseException {
        return ResponseEntity.ok(ReviewDto.toBasic(reviewService.save(e)));
    }

    // GET
    @Operation(summary = "Get all reviews.")
    @GetMapping("/reviews")
    public ResponseEntity<List<ReviewDto>> getReviews() throws BaseException {
        return ResponseEntity
                .ok(reviewService.getAll().stream().map(ReviewDto::toBasic).collect(Collectors.toList()));
    }

    @Operation(summary = "Get a review.")
    @GetMapping("/reviews/{id}")
    public ResponseEntity<ReviewDto> getReview(@PathVariable Long id) throws BaseException {
        return ResponseEntity.ok(ReviewDto.toBasic(reviewService.get(id)));
    }

    // PUT
    @Operation(summary = "Update a review.")
    @PutMapping("reviews/{id}")
    public ResponseEntity<ReviewDto> updateReview(@PathVariable Long id, @RequestBody ReviewDto e)
            throws BaseException {
        return ResponseEntity.ok(ReviewDto.toBasic(reviewService.update(id, e)));
    }

    // DELETE
    @Operation(summary = "Delete a review.")
    @DeleteMapping("reviews/{id}")
    public void deleteReview(@PathVariable Long id) throws BaseException {
        reviewService.delete(id);
    }

}

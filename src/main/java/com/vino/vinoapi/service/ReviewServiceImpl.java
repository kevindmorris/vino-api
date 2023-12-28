package com.vino.vinoapi.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vino.vinoapi.dto.ReviewDto;
import com.vino.vinoapi.exception.BaseException;
import com.vino.vinoapi.model.Review;
import com.vino.vinoapi.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Review save(ReviewDto e) throws BaseException {
        return reviewRepository.save(new Review(e.getDescription()));
    }

    @Override
    public List<Review> getAll() throws BaseException {
        return reviewRepository.findAll();
    }

    @Override
    public Review get(Long id) throws BaseException {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new BaseException("No review found with that id : " + id));
    }

    @Override
    public Review update(Long id, ReviewDto e) throws BaseException {
        Optional<Review> optional = reviewRepository.findById(id);

        if (optional.isEmpty())
            throw new BaseException("No review found with that id : " + id);

        Review review = optional.get();

        if (Objects.nonNull(e.getDescription()))
            review.setDescription(e.getDescription());

        return reviewRepository.save(review);
    }

    @Override
    public void delete(Long id) throws BaseException {
        Optional<Review> optional = reviewRepository.findById(id);

        if (optional.isEmpty())
            throw new BaseException("No review found with that id : " + id);

        reviewRepository.deleteById(id);
    }

}

package com.vino.vinoapi.service;

import java.util.List;

import com.vino.vinoapi.dto.ReviewDto;
import com.vino.vinoapi.exception.BaseException;
import com.vino.vinoapi.model.Review;

public interface ReviewService {

    public Review save(Long wineId, ReviewDto e) throws BaseException;

    public List<Review> getAll() throws BaseException;

    public List<Review> getByWineId(Long wineId) throws BaseException;

    public Review get(Long id) throws BaseException;

    public Review update(Long id, ReviewDto e) throws BaseException;

    public void delete(Long id) throws BaseException;

}

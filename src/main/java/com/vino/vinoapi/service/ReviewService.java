package com.vino.vinoapi.service;

import java.util.List;

import com.vino.vinoapi.exception.BaseException;
import com.vino.vinoapi.model.Review;

public interface ReviewService {

    public Review save(Review e) throws BaseException;

    public List<Review> getAll() throws BaseException;

    public Review get(Long id) throws BaseException;

    public Review update(Long id, Review e) throws BaseException;

    public void delete(Long id) throws BaseException;

}

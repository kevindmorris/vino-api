package com.vino.vinoapi.service;

import java.util.List;

import com.vino.vinoapi.dto.WineDto;
import com.vino.vinoapi.exception.BaseException;
import com.vino.vinoapi.model.Wine;

public interface WineService {

    public Wine save(WineDto e) throws BaseException;

    public List<Wine> getAll() throws BaseException;

    public Wine get(Long id) throws BaseException;

    public Wine update(Long id, WineDto e) throws BaseException;

    public void delete(Long id) throws BaseException;

}

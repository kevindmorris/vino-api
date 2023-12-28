package com.vino.vinoapi.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vino.vinoapi.dto.WineDto;
import com.vino.vinoapi.exception.BaseException;
import com.vino.vinoapi.model.Wine;
import com.vino.vinoapi.repository.WineRepository;

@Service
public class WineServiceImpl implements WineService {

    @Autowired
    private WineRepository wineRepository;

    @Override
    public Wine save(WineDto e) throws BaseException {
        return wineRepository.save(new Wine(e.getName(), e.getType(), e.getDescription()));
    }

    @Override
    public List<Wine> getAll() throws BaseException {
        return wineRepository.findAll();
    }

    @Override
    public Wine get(Long id) throws BaseException {
        return wineRepository.findById(id).orElseThrow(() -> new BaseException("No wine found with that id : " + id));
    }

    @Override
    public Wine update(Long id, WineDto e) throws BaseException {
        Optional<Wine> optional = wineRepository.findById(id);

        if (optional.isEmpty())
            throw new BaseException("No wine found with that id : " + id);

        Wine wine = optional.get();

        if (Objects.nonNull(e.getDescription()))
            wine.setDescription(e.getDescription());

        return wineRepository.save(wine);
    }

    @Override
    public void delete(Long id) throws BaseException {
        Optional<Wine> optional = wineRepository.findById(id);

        if (optional.isEmpty())
            throw new BaseException("No wine found with that id : " + id);

        wineRepository.deleteById(id);
    }

}

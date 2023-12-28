package com.vino.vinoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vino.vinoapi.model.Wine;

public interface WineRepository extends JpaRepository<Wine, Long> {

}

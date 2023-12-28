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

import com.vino.vinoapi.dto.WineDto;
import com.vino.vinoapi.exception.BaseException;
import com.vino.vinoapi.service.WineService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@Tag(name = "1. Wine Controller", description = "This controller exposes endpoints to manage wine content.")
public class WineController {

    @Autowired
    WineService wineService;

    // POST
    @Operation(summary = "Create a wine.")
    @PostMapping("/wines")
    public ResponseEntity<WineDto> createWine(@RequestBody WineDto e) throws BaseException {
        return ResponseEntity.ok(WineDto.toComplex(wineService.save(e)));
    }

    // GET
    @Operation(summary = "Get all wines.")
    @GetMapping("/wines")
    public ResponseEntity<List<WineDto>> getWines() throws BaseException {
        return ResponseEntity
                .ok(wineService.getAll().stream().map(WineDto::toBasic).collect(Collectors.toList()));
    }

    @Operation(summary = "Get a wine.")
    @GetMapping("/wines/{id}")
    public ResponseEntity<WineDto> getWine(@PathVariable Long id) throws BaseException {
        return ResponseEntity.ok(WineDto.toComplex(wineService.get(id)));
    }

    // PUT
    @Operation(summary = "Update a wine.")
    @PutMapping("wines/{id}")
    public ResponseEntity<WineDto> updateWine(@PathVariable Long id, @RequestBody WineDto e)
            throws BaseException {
        return ResponseEntity.ok(WineDto.toComplex(wineService.update(id, e)));
    }

    // DELETE
    @Operation(summary = "Delete a wine.")
    @DeleteMapping("wines/{id}")
    public void deleteWine(@PathVariable Long id) throws BaseException {
        wineService.delete(id);
    }

}

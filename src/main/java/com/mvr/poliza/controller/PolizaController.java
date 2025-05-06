package com.mvr.poliza.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mvr.poliza.dtos.PolizaDto;
import com.mvr.poliza.dtos.response.ApiResponse;
import com.mvr.poliza.services.PolizasService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("v1/poliza")
@RequiredArgsConstructor
public class PolizaController {

    final PolizasService polizasService;

    @GetMapping
    public ResponseEntity<ApiResponse<PolizaDto>> getPoliza(@RequestParam(name = "idPoliza") Integer idPoliza) {
        var poliza = polizasService.getIdPoliza(idPoliza);
        return ResponseEntity.ok().body(poliza);
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<PolizaDto>>> getAllPolizas() {
        var polizas = polizasService.getAllPolizas();
        return ResponseEntity.ok().body(polizas);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<PolizaDto>> savePoliza(@Valid @RequestBody PolizaDto polizaDto) {
        var savePoliza = polizasService.savePoliza(polizaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savePoliza);
    }

    @DeleteMapping
    public ResponseEntity<ApiResponse<String>> deletePolizaId(@RequestParam(name = "idPoliza") Integer idPoliza) {
        var poliza = polizasService.deletePoliza(idPoliza);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(poliza);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<ApiResponse<String>> updatePoliza(@RequestParam(name = "idPoliza") Integer idPoliza,
            @RequestParam(name = "newCantidad") int newCantidad) {
        var updatePoliza = polizasService.updatePoliza(idPoliza, newCantidad);
        return ResponseEntity.status(HttpStatus.OK).body(updatePoliza);
    }

}
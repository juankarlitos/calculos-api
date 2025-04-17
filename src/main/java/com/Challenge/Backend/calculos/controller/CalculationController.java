package com.Challenge.Backend.calculos.controller;

import com.Challenge.Backend.calculos.model.dto.CalculationRequest;
import com.Challenge.Backend.calculos.model.dto.CalculationResponse;
import com.Challenge.Backend.calculos.model.entity.CallHistory;
import com.Challenge.Backend.calculos.repository.CallHistoryRepository;
import com.Challenge.Backend.calculos.service.CalculationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Tag(name = "Calculadora", description = "Operaciones de cálculo")
public class CalculationController {

    private final CalculationService calculationService;
    private final CallHistoryRepository callHistoryRepository;

    @Operation(summary = "Suma con porcentaje dinámico")
    @PostMapping("/calcular")
    public ResponseEntity<CalculationResponse> calculate(@RequestBody CalculationRequest request) {
        CalculationResponse response = calculationService.calculateWithPercentage(request);
        return ResponseEntity.ok(response);
    }
    @Operation(summary = "Suma con porcentaje dinámico")
    @GetMapping("/historial")
    public ResponseEntity<List<CallHistory>> getHistory() {
        return ResponseEntity.ok(callHistoryRepository.findAll());
    }
}
package com.Challenge.Backend.calculos.service;

import com.Challenge.Backend.calculos.model.dto.CalculationRequest;
import com.Challenge.Backend.calculos.model.dto.CalculationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CalculationService {

    private final PercentageService percentageService;
    private final HistoryService historyService;

    public CalculationResponse calculateWithPercentage(CalculationRequest request) {
        String endpoint = "/api/calcular";
        String params = "num1=" + request.num1() + ", num2=" + request.num2();
        try {
            log.info("Calculando con: num1={}, num2={}", request.num1(), request.num2());
            double suma = request.num1() + request.num2();
            double porcentajes = percentageService.getPorcentage();

            log.info("Porcentaje obtenido: {}", porcentajes);

            double resultado = suma * (1 + porcentajes / 100);

            historyService.saveCall(endpoint, params, String.valueOf(resultado), true);
            return new CalculationResponse(resultado);

        } catch (Exception e) {
            historyService.saveCall(endpoint, params, e.getMessage(), false);
            throw new RuntimeException("Error en cálculo: " + e.getMessage());
        }
    }
}
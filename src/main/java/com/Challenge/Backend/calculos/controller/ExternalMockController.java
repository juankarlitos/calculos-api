package com.Challenge.Backend.calculos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExternalMockController {

    @GetMapping("/mock/porcentaje")
    public double getMockPercentage() {
        return 10.0; // Valor porciento simulado del servicio externo
    }
}
package com.Challenge.Backend.calculos.service;

import com.Challenge.Backend.calculos.model.dto.CalculationRequest;
import com.Challenge.Backend.calculos.model.dto.CalculationResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class CalculationServiceTest {
    private PercentageService percentageService;
    private HistoryService historyService;
    private CalculationService calculationService;

    @BeforeEach
    void setUp() {
        percentageService = mock(PercentageService.class);
        historyService = mock(HistoryService.class);
        calculationService = new CalculationService(percentageService, historyService);
    }

    @Test
    void shouldCalculateSumWithPercentage() {
        CalculationRequest request = new CalculationRequest(100.0, 50.0);
        when(percentageService.getPorcentage()).thenReturn(10.0);

        CalculationResponse response = calculationService.calculateWithPercentage(request);

        assertEquals(165.0, response.result());
        verify(historyService).saveCall(any(), any(), any(), eq(true));
    }

    @Test
    void shouldThrowExceptionWhenPercentageFails() {
        CalculationRequest request = new CalculationRequest(20.0, 30.0);
        when(percentageService.getPorcentage()).thenThrow(new RuntimeException("Falla externa"));

        RuntimeException ex = assertThrows(RuntimeException.class, () ->
                calculationService.calculateWithPercentage(request));

        assertEquals("Error en cálculo: Falla externa", ex.getMessage());
        verify(historyService).saveCall(any(), any(), eq("Falla externa"), eq(false));
    }
}

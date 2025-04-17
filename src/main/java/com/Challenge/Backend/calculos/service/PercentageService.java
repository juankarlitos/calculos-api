package com.Challenge.Backend.calculos.service;


import com.Challenge.Backend.calculos.constants.CacheNames;
import com.Challenge.Backend.calculos.exception.ExternalServiceUnavailableException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class PercentageService {

    private final RestTemplate restTemplate;

   // public static final String CACHE_PORCENTAJE = "porcentaje";

    @Cacheable(CacheNames.PORCENTAJE)
    public double getPorcentage() {
        log.info("Llamando a servicio externo simulado...");
        try {
            // Llama al endpoint simulado local
            return restTemplate.getForObject("http://localhost:8097/mock/porcentaje", Double.class);
        } catch (Exception e) {
            log.error("Error al obtener porcentaje externo: {}", e.getMessage());
            throw new ExternalServiceUnavailableException("No se pudo obtener el porcentaje dinámico");
        }
    }
}

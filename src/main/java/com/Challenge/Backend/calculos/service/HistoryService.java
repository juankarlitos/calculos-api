package com.Challenge.Backend.calculos.service;

import com.Challenge.Backend.calculos.model.entity.CallHistory;
import com.Challenge.Backend.calculos.repository.CallHistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class HistoryService {

    private final CallHistoryRepository repository;

    @Async
    public void saveCall(String endpoint, String parameters, String response, boolean success) {
        try {
            CallHistory call = new CallHistory();
            call.setTimestamp(LocalDateTime.now());
            call.setEndpoint(endpoint);
            call.setParameters(parameters);
            call.setResponse(response);
            call.setSuccess(success);

            repository.save(call);
            log.info("Historial guardado correctamente");
        } catch (Exception e) {
            log.error("Error al guardar historial: {}", e.getMessage());
        }
    }
}

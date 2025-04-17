package com.Challenge.Backend.calculos.repository;

import com.Challenge.Backend.calculos.model.entity.CallHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CallHistoryRepository extends JpaRepository<CallHistory, Long> {
}
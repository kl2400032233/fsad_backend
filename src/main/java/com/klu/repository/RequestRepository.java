package com.klu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klu.model.Request;

public interface RequestRepository extends JpaRepository<Request, Long> {
}
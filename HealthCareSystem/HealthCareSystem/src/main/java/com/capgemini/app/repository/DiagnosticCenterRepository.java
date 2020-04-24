package com.capgemini.app.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.capgemini.app.entities.DiagnosticCenter;

@Repository
public interface DiagnosticCenterRepository extends JpaRepository<DiagnosticCenter,Long> {
	
}

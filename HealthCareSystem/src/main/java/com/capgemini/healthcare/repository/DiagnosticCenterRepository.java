package com.capgemini.healthcare.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.capgemini.healthcare.entity.DiagnosticCenter;;

@Repository
public interface DiagnosticCenterRepository extends JpaRepository<DiagnosticCenter,Long> {
	
}

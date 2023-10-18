package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Diagnostic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosticRepository extends JpaRepository<Diagnostic, Long> {
    public Diagnostic findDiagnosticById(Long Id);
}

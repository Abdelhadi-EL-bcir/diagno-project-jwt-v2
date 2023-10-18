package com.bezkoder.springjwt.security.services.facades;


import com.bezkoder.springjwt.models.Diagnostic;

public interface DiagnosticService {
    public Diagnostic create(Diagnostic diagnostic);
    public String getScoreGlobal(Long id);
    public String getScoreByCat(Long id,Long idCat);
    public Diagnostic getDiagnostic(Long id);
}

package com.bezkoder.springjwt.controllers;


import com.bezkoder.springjwt.models.Diagnostic;
import com.bezkoder.springjwt.security.services.DiagnosticServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/diagno")
public class DiagnosticController {
    @Autowired
    private DiagnosticServiceImpl diagnosticServiceImpl;

    @PostMapping("/add")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Diagnostic create(@RequestBody Diagnostic diagnostic) {
        return diagnosticServiceImpl.create(diagnostic);
    }

    @GetMapping("/getGlobal/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String getScoreGlobal(@PathVariable Long id) {
        return diagnosticServiceImpl.getScoreGlobal(id);
    }

    @GetMapping("/getByCat/{id}/{idCat}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String getScoreByCat(@PathVariable Long id,@PathVariable Long idCat) {
        return diagnosticServiceImpl.getScoreByCat(id, idCat);
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Diagnostic getDiagnostic(@PathVariable Long id){
        return diagnosticServiceImpl.getDiagnostic(id);
    }
}

package com.pdi.pdi_caio.controller;

import com.pdi.pdi_caio.model.Enfermeiro;
import com.pdi.pdi_caio.service.EnfermeiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enfermeiros")
public class EnfermeiroController {

    @Autowired
    private EnfermeiroService enfermeiroService;

    @PostMapping
    public ResponseEntity<Enfermeiro> criarEnfermeiro(@RequestBody Enfermeiro enfermeiro) {
        Enfermeiro novoEnfermeiro = enfermeiroService.criarEnfermeiro(enfermeiro);
        return new ResponseEntity<>(novoEnfermeiro, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Enfermeiro>> listarEnfermeiros() {
        List<Enfermeiro> enfermeiros = enfermeiroService.listarTodos();
        return ResponseEntity.ok(enfermeiros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enfermeiro> buscarEnfermeiroPorId(@PathVariable Long id) {
        Enfermeiro enfermeiro = enfermeiroService.buscarPorId(id);
        return ResponseEntity.ok(enfermeiro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Enfermeiro> atualizarEnfermeiro(@PathVariable Long id, @RequestBody Enfermeiro enfermeiro) {
        Enfermeiro enfermeiroAtualizado = enfermeiroService.atualizarEnfermeiro(id, enfermeiro);
        return ResponseEntity.ok(enfermeiroAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEnfermeiro(@PathVariable Long id) {
        enfermeiroService.deletarEnfermeiro(id);
        return ResponseEntity.noContent().build();
    }
}

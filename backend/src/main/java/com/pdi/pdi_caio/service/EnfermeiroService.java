package com.pdi.pdi_caio.service;

import com.pdi.pdi_caio.model.Enfermeiro;
import com.pdi.pdi_caio.repository.EnfermeiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnfermeiroService {

    @Autowired
    private EnfermeiroRepository enfermeiroRepository;

    public Enfermeiro criarEnfermeiro(Enfermeiro enfermeiro) {
        if (enfermeiroRepository.existsByCpf(enfermeiro.getCpf())) {
            throw new IllegalArgumentException("O CPF já está cadastrado.");
        }
        return enfermeiroRepository.save(enfermeiro);
    }

    public List<Enfermeiro> listarTodos() {
        return enfermeiroRepository.findAll();
    }

    public Enfermeiro buscarPorId(Long id) {
        return enfermeiroRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Enfermeiro não encontrado."));
    }

    public Enfermeiro atualizarEnfermeiro(Long id, Enfermeiro dadosAtualizados) {
        Enfermeiro enfermeiro = buscarPorId(id);
        enfermeiro.setNome(dadosAtualizados.getNome());
        enfermeiro.setCpf(dadosAtualizados.getCpf());
        enfermeiro.setSenha(dadosAtualizados.getSenha());
        return enfermeiroRepository.save(enfermeiro);
    }

    public void deletarEnfermeiro(Long id) {
        Enfermeiro enfermeiro = buscarPorId(id);
        enfermeiroRepository.delete(enfermeiro);
    }
}

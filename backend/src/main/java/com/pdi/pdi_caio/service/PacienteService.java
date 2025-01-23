package com.pdi.pdi_caio.service;

import com.pdi.pdi_caio.model.Paciente;
import com.pdi.pdi_caio.repository.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente criarPaciente(Paciente paciente) {
        if (pacienteRepository.existsByCpf(paciente.getCpf())) {
            throw new IllegalArgumentException("O CPF já está cadastrado.");
        }
        return pacienteRepository.save(paciente);
    }

    public List<Paciente> listarTodos() {
        return pacienteRepository.findAll();
    }

    public Paciente buscarPorId(Long id) {
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Paciente não encontrado."));
    }

    public Paciente atualizarPaciente(Long id, Paciente dadosAtualizados) {
        Paciente paciente = buscarPorId(id);

        paciente.setNome(dadosAtualizados.getNome());
        paciente.setCpf(dadosAtualizados.getCpf());
        paciente.setDataNascimento(dadosAtualizados.getDataNascimento());
        paciente.setPeso(dadosAtualizados.getPeso());
        paciente.setAltura(dadosAtualizados.getAltura());
        paciente.setUf(dadosAtualizados.getUf());

        return pacienteRepository.save(paciente);
    }

    public void deletarPaciente(Long id) {
        Paciente paciente = buscarPorId(id);
        pacienteRepository.delete(paciente);
    }

}

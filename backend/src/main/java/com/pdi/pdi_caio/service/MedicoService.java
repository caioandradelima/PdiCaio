package com.pdi.pdi_caio.service;

import com.pdi.pdi_caio.model.Medico;
import com.pdi.pdi_caio.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public Medico criarMedico(Medico medico) {
        if (medicoRepository.existsByCpf(medico.getCpf())) {
            throw new IllegalArgumentException("O CPF já está cadastrado.");
        }
        return medicoRepository.save(medico);
    }

    public List<Medico> listarTodos() {
        return medicoRepository.findAll();
    }

    public Medico buscarPorId(Long id) {
        return medicoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Médico não encontrado."));
    }

    public Medico atualizarMedico(Long id, Medico dadosAtualizados) {
        Medico medico = buscarPorId(id);
        medico.setNome(dadosAtualizados.getNome());
        medico.setCpf(dadosAtualizados.getCpf());
        medico.setSenha(dadosAtualizados.getSenha());
        return medicoRepository.save(medico);
    }

    public void deletarMedico(Long id) {
        Medico medico = buscarPorId(id);
        medicoRepository.delete(medico);
    }
}

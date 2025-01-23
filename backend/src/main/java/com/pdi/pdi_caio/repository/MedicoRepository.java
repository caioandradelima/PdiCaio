package com.pdi.pdi_caio.repository;

import com.pdi.pdi_caio.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    boolean existsByCpf(String cpf);
}

package com.pdi.pdi_caio.repository;

import com.pdi.pdi_caio.model.Enfermeiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnfermeiroRepository extends JpaRepository<Enfermeiro, Long> {
    boolean existsByCpf(String cpf);
}

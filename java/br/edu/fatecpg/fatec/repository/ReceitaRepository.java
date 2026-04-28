package br.edu.fatecpg.fatec.repository;

import br.edu.fatecpg.fatec.model.ReceitasEmPromocao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReceitaRepository
        extends JpaRepository<ReceitasEmPromocao,Long> {
        List<ReceitasEmPromocao> findByEmPromocaoTrue();
}

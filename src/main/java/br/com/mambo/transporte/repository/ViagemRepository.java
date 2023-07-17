package br.com.mambo.transporte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mambo.transporte.model.Viagem;

@Repository
public interface ViagemRepository extends JpaRepository<Viagem, Long> {

}

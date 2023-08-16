package br.com.mambo.transporte.persistencia.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.mambo.transporte.model.Viagem;

@Repository
public interface ViagemRepository extends JpaRepository<Viagem, Long> {
	
	@Query(value = "SELECT v FROM Viagem as v WHERE v.horarios.data = ?1 ORDER BY v.horaDoRegistro DESC")
	List<Viagem> findAllData(LocalDate data);

}

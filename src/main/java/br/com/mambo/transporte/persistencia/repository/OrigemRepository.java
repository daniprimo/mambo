package br.com.mambo.transporte.persistencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mambo.transporte.model.Origem;

@Repository 
public interface OrigemRepository extends JpaRepository<Origem, String>{

}

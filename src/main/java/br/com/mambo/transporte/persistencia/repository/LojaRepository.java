package br.com.mambo.transporte.persistencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mambo.transporte.model.Loja;

@Repository
public interface LojaRepository extends JpaRepository<Loja, String>{

}

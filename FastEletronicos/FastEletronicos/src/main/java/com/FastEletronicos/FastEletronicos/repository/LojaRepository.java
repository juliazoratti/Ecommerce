package com.FastEletronicos.FastEletronicos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FastEletronicos.FastEletronicos.model.Loja;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Long>{
	
	//public List<Loja> findAllByNomeLojaContainingIgoneCase (String nomeLoja);

}

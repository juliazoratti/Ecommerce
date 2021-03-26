package com.FastEletronicos.FastEletronicos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.FastEletronicos.FastEletronicos.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	public List<Produto> findAllByTituloProdutoContainingIgnoreCase (String tituloProduto);
	
	public List<Produto> findAllByValorLessThanEqual (double valor);
	
	public List<Produto> findAllByValorGreaterThanEqual (double valor);
	
	@Query(value = "SELECT * FROM tb_produto where valor = :valor", nativeQuery = true)
	public List<Produto> findAllByValor(@Param("valor") double valor);	

}

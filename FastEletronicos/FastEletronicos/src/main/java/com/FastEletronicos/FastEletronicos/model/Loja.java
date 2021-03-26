package com.FastEletronicos.FastEletronicos.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "tb_loja")
public class Loja {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long idLoja;
	
	@Size (min = 5, max = 45)
	private String nomeLoja;
	
	@Size (min = 5, max = 100)
	private String descricaoLoja;
	
	@ManyToOne
	@JsonIgnoreProperties("loja")
	private Produto produto;
	
	@OneToMany(mappedBy = "loja", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("loja")
	private List<Usuario> usuario;
	
	public long getIdLoja() {
		return idLoja;
	}

	public void setIdLoja(long idLoja) {
		this.idLoja = idLoja;
	}

	public String getNomeLoja() {
		return nomeLoja;
	}

	public void setNomeLoja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
	}

	public String getDescricaoLoja() {
		return descricaoLoja;
	}

	public void setDescricaoLoja(String descricaoLoja) {
		this.descricaoLoja = descricaoLoja;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}
	

}

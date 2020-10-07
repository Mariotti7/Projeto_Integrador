package com.api.projetoIntegrador.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "produto")
public class ProdutoModelo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_produto;
	
	private String nome_curso;

	private String descricao;

	private Long custo_monitoria;

	private Long ganho_aula;

	private Long ganho_prova;
	
	@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("produto")
	private List<CategoriaModelo> categoria;

	public Long getId_produto() {
		return id_produto;
	}

	public void setId_produto(Long id_produto) {
		this.id_produto = id_produto;
	}

	public String getNome_curso() {
		return nome_curso;
	}

	public void setNome_curso(String nome_curso) {
		this.nome_curso = nome_curso;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getCusto_monitoria() {
		return custo_monitoria;
	}

	public void setCusto_monitoria(Long custo_monitoria) {
		this.custo_monitoria = custo_monitoria;
	}

	public Long getGanho_aula() {
		return ganho_aula;
	}

	public void setGanho_aula(Long ganho_aula) {
		this.ganho_aula = ganho_aula;
	}

	public Long getGanho_prova() {
		return ganho_prova;
	}

	public void setGanho_prova(Long ganho_prova) {
		this.ganho_prova = ganho_prova;
	}

	public List<CategoriaModelo> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<CategoriaModelo> categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_produto == null) ? 0 : id_produto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoModelo other = (ProdutoModelo) obj;
		if (id_produto == null) {
			if (other.id_produto != null)
				return false;
		} else if (!id_produto.equals(other.id_produto))
			return false;
		return true;
	}

}

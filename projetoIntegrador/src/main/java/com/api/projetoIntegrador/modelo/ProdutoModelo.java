package com.api.projetointegrador.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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

	@ManyToOne
	@JsonIgnoreProperties("produto")
	private CategoriaModelo categoria;

	@ManyToOne
	@JsonIgnoreProperties("criadorCurso")
	private UsuarioModelo cursoCriado;

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


	public CategoriaModelo getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaModelo categoria) {
		this.categoria = categoria;
	}

	public UsuarioModelo getCursoCriado() {
		return cursoCriado;
	}

	public void setCursoCriado(UsuarioModelo cursoCriado) {
		this.cursoCriado = cursoCriado;
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

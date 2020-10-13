package com.api.projetoIntegrador.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "usuario")
public class UsuarioModelo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuario;

	private String nome;

	private String email;

	private String senha;

	private Long pontuacao;

	@OneToMany(mappedBy = "cursoCriado", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("cursoCriado")
	private List<ProdutoModelo> criadorCurso;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("estudante")
	@JoinTable(name="cursoEstudado", joinColumns = @JoinColumn(name="produto_id_curso"),
	inverseJoinColumns = @JoinColumn(name="usuario_id_estudante"))
	private List<UsuarioModelo> cursoEstudado;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("monitor")
	@JoinTable(name="cursoMonitorado", joinColumns = @JoinColumn(name="produto_id_monitorado"),
	inverseJoinColumns = @JoinColumn(name="usuario_id_monitor"))
	private List<ProdutoModelo> cursoMonitorado;

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(Long pontuacao) {
		this.pontuacao = pontuacao;
	}

	public List<ProdutoModelo> getCriadorCurso() {
		return criadorCurso;
	}

	public void setCriadorCurso(List<ProdutoModelo> criadorCurso) {
		this.criadorCurso = criadorCurso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_usuario == null) ? 0 : id_usuario.hashCode());
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
		UsuarioModelo other = (UsuarioModelo) obj;
		if (id_usuario == null) {
			if (other.id_usuario != null)
				return false;
		} else if (!id_usuario.equals(other.id_usuario))
			return false;
		return true;
	}

}

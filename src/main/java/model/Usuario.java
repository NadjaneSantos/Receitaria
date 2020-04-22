package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Nadjane
 *
 */
@Entity
@Table(name = "usuario")
public class Usuario {

	@Column(name = "nome")
	private String nome;

	@Id
	@Column(name = "email")
	private String email;

	@Column(name = "senha")
	private String senha;

	public Usuario() {

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

}

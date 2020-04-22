package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Nadjane
 *
 */
@Entity
@Table(name = "ingrediente")
public class Ingrediente {

	@Id
	@Column(name = "id")
	private long id;

	@Column(name = "quantidade")
	private String quantidade;

	@Column(name = "medida")
	private String medida;

	@Column(name = "ingrediente")
	private String ingrediente;

	@ManyToOne
	@JoinColumn(name = "id_receita", referencedColumnName = "id", nullable = false)
	private Receita receita;

	public Ingrediente() {

	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getMedida() {
		return medida;
	}

	public void setMedida(String medida) {
		this.medida = medida;
	}

	public String getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(String ingrediente) {
		this.ingrediente = ingrediente;
	}

	public Receita getReceita() {
		return receita;
	}

	public void setReceita(Receita receita) {
		this.receita = receita;
	}

}

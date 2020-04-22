package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Nadjane
 *
 */
@Entity
@Table(name = "receita")
public class Receita {

	@Id
	@Column(name = "id")
	private long id;

	@Column(name = "titulo")
	private String titulo;

	@ManyToOne
	@JoinColumn(name = "id_profissional", referencedColumnName = "id")
	private Profissional profissional;

	@Column(name = "categoria")
	private String categoria;

	@OneToMany(mappedBy = "receita", cascade = CascadeType.ALL)
	private List<Ingrediente> listaIngrediente;

	@Column(name = "modoPreparo")
	private String modoPreparo;

	public Receita() {

	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public List<Ingrediente> getListaIngrediente() {
		return listaIngrediente;
	}

	public void setListaIngrediente(List<Ingrediente> listaIngrediente) {
		this.listaIngrediente = listaIngrediente;
	}

	public String getModoPreparo() {
		return modoPreparo;
	}

	public void setModoPreparo(String modoPreparo) {
		this.modoPreparo = modoPreparo;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

}

package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import JPAUtil.JPAUtil;
import dao.ReceitaDao;
import model.Ingrediente;
import model.Profissional;
import model.Receita;

/**
 * @author Nadjane
 *
 */
@ManagedBean(name = "ReceitaBean")
@SessionScoped
public class ReceitaBean {

	private Receita receita;
	private Profissional profissional;
	private Ingrediente ingrediente;
	private List<Receita> listaReceitas;
	private ReceitaDao receitaDao;
	private long id;
	private static final String MANTER = "ManterReceita.xhtml";
	private static final String PESQUISAR = "ListarReceita.xhtml";

	public ReceitaBean() {

		this.profissional = new Profissional();
		this.receita = new Receita();
		this.receita.setListaIngrediente(new ArrayList<Ingrediente>());
		this.receita.setProfissional(new Profissional());
		this.ingrediente = new Ingrediente();
		this.listaReceitas = new ArrayList<Receita>();
		this.receitaDao = new ReceitaDao(JPAUtil.getEntityManager());
		//
	}

	public void gravar() throws IOException {

		if (this.receitaDao.gravar(this.receita)) {
			abrirPesquisarReceita();
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Erro ao inserir."));
		}

	}

	public void abrirPesquisarReceita() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect(PESQUISAR);
	}

	public void abrirManterReceita() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect(MANTER);
	}

	public String remover() {
		Receita removerReceita = this.receitaDao.pesquisarReceita(id);
		this.receitaDao.remover(removerReceita);
		this.listaReceitas = this.receitaDao.listarReceitas();

		return "";
	}

	public void listarReceitas() {

		this.listaReceitas = this.receitaDao.listarReceitas();
	}

	public void addIngrediente() {

		Ingrediente newIngrediente = new Ingrediente();
		newIngrediente.setQuantidade(this.ingrediente.getQuantidade());
		newIngrediente.setMedida(this.ingrediente.getMedida());
		newIngrediente.setIngrediente(this.ingrediente.getIngrediente());
		newIngrediente.setReceita(this.receita);

		this.receita.getListaIngrediente().add(newIngrediente);
		this.ingrediente = new Ingrediente();
	}

	public void limpar() {
		this.listaReceitas = new ArrayList<Receita>();
		this.receita = new Receita();
		this.receita.setListaIngrediente(new ArrayList<Ingrediente>());
		this.ingrediente = new Ingrediente();
	}

	public Receita getReceita() {
		return receita;
	}

	public void setReceita(Receita receita) {
		this.receita = receita;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	public List<Receita> getListaReceitas() {
		return listaReceitas;
	}

	public void setListaReceitas(List<Receita> listaReceitas) {
		this.listaReceitas = listaReceitas;
	}

	public ReceitaDao getReceitaDao() {
		return receitaDao;
	}

	public void setReceitaDao(ReceitaDao receitaDao) {
		this.receitaDao = receitaDao;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}

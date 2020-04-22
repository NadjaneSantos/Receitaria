package controller;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import JPAUtil.JPAUtil;
import dao.UsuarioDao;
import model.Usuario;

/**
 * @author Nadjane
 *
 */
@ManagedBean(name = "UsuarioBean")
@SessionScoped
public class UsuarioBean {

	private Usuario usuario;
	private String msg;
	private UsuarioDao usuarioDao;

	private static final String LOGIN = "login.xhtml";

	public UsuarioBean() {
		this.usuario = new Usuario();
		this.usuarioDao = new UsuarioDao(JPAUtil.getEntityManager());
	}

	public void salvar() throws IOException {

		if (this.usuarioDao.gravar(this.usuario)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Usuário inserido com sucesso"));

			abrirLogin();

		} else {
			this.msg = "Erro inserir, verifique os dados e tente novamente";
		}

	}

	public void abrirLogin() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect(LOGIN);
	}

	public void limpar() {

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}

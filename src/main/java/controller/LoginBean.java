package controller;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import JPAUtil.JPAUtil;
import dao.UsuarioDao;
import model.Usuario;
/**
 * @author Nadjane
 *
 */
@ManagedBean(name = "LoginBean")
@RequestScoped
public class LoginBean {

	private String usuarioInpt;
	private String senhaInpt;
	private String msg;
	private UsuarioDao usuarioDao;
	private static final String CADASTROUSUARIO = "CadastroUsuario.xhtml";
	private static final String LISTAR = "ListarReceita.xhtml";

	public LoginBean() {
		this.usuarioDao = new UsuarioDao(JPAUtil.getEntityManager());
	}

	// verificar se existe no banco

	public void entrar() throws IOException {

		Usuario pesquisarUsuario = this.usuarioDao.pesquisar(this.usuarioInpt);

		if (pesquisarUsuario != null) {
			if (this.senhaInpt.equals(pesquisarUsuario.getSenha())) {
				FacesContext.getCurrentInstance().getExternalContext().redirect(LISTAR);
			} else {
				this.msg = "Senha Incorreta";
			}

		} else {
			this.msg = ("Usuário: " + usuarioInpt + " não está cadastrado.");
		}
	}
	// pesquisar o email do userinpt no usuario dao

	public void cadastroUsuario() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect(CADASTROUSUARIO);
	}

	public String getUsuarioInpt() {
		return usuarioInpt;
	}

	public void setUsuarioInpt(String usuarioInpt) {
		this.usuarioInpt = usuarioInpt;
	}

	public String getSenhaInpt() {
		return senhaInpt;
	}

	public void setSenhaInpt(String senhaInpt) {
		this.senhaInpt = senhaInpt;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

}

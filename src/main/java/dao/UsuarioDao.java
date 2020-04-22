package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Usuario;

/**
 * @author Nadjane
 *
 */
public class UsuarioDao {

	private EntityManager em;

	public UsuarioDao(EntityManager em) {
		this.em = em;
	}

	public boolean gravar(Usuario usuario) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(usuario);
		et.commit();
		return true;
	}

	public void remover(Usuario usuario) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(usuario);
		et.commit();
	}

	public Usuario pesquisar(String email) {
		Usuario usuario = em.find(Usuario.class, email);
		return usuario;
	}

}

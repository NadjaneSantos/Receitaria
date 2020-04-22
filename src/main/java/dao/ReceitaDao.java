package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Receita;

/**
 * @author Nadjane
 *
 */
public class ReceitaDao {

	private EntityManager em;

	public ReceitaDao(EntityManager em) {
		this.em = em;
	}

	public boolean gravar(Receita receita) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(receita);
		et.commit();
		return true;

	}

	public void remover(Receita receita) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(receita);
		et.commit();
	}

	public Receita pesquisarReceita(long id) {
		Receita receita = em.find(Receita.class, id);
		return receita;
	}

	public List<Receita> listarReceitas() {

		Query query = em.createQuery("from receita r");

		@SuppressWarnings("unchecked")
		List<Receita> receitas = query.getResultList();

		return receitas;

	}

}

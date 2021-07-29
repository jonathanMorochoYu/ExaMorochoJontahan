package Dato;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Modelo.Universidad;

@Stateless
public class UniversidadDao {
	
	@PersistenceContext
	private EntityManager em;

	public void insert(Universidad universidad) {
		em.persist(universidad);
	}

	public void update(Universidad universidad) {
		em.merge(universidad);
	}

	public Universidad read(String codigoUni) {
		Universidad p = em.find(Universidad.class, codigoUni);
		return p;
	}

	public void delete(String codigoUni) {
		Universidad p = em.find(Universidad.class, codigoUni);
		em.remove(p);
	}

	public List<Universidad> getUniversidades(String codigoUni){
		
		String jpql2="SELECT p FROM Universidad p WHERE nombre LIKE ?1";
		
		codigoUni= codigoUni+"%";
		Query query= em.createQuery(jpql2, Universidad.class);
		query.setParameter(1, codigoUni);
		
		List<Universidad> universidades=query.getResultList();
		return universidades;
		
	}
}




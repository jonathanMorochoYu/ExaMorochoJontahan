package Dato;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import Modelo.Carrera;

public class CarreraDao {
	
	@PersistenceContext(name = "EvaluacionWSYupankiMalkiPersistenceUnit")
	private EntityManager em;
	
	
	public void insert(Carrera s) {
		em.persist(s);
	}
	
	
	public void update(Carrera s) {
		em.merge(s);
	}
	
	
	public Carrera read(int codigoTransaccion) {
		return em.find(Titulo.class, codigoTransaccion);
	}
	
	
	
	public void delete(int codT) {
		Carrera c = read(codT);
		em.remove(c);
	}
	
	
	public List<Carrera> getListaTransacciones(String cedula) throws Exception {
		try {
			String jpql = "SELECT s FROM Titulo s Where s.cedula.cedula =:ced";
			Query q = em.createQuery(jpql, Carrera.class);
			q.setParameter("ced", cedula);
			return q.getResultList();
		} catch (NoResultException e) {
			// System.out.println(e.getMessage());
			throw new Exception("No Existe La institucion");
		}

	}
	
	
	public List<Carrera> getListaTitulos(String palabra) throws Exception {
		try {
			String jpql = "SELECT s FROM Titulo s Where s.titulo like '%"+palabra+"%'";
			Query q = em.createQuery(jpql, Carrera.class);
			return q.getResultList();
		} catch (NoResultException e) {
			// System.out.println(e.getMessage());
			throw new Exception("Credenciaales Inocorrectas");
		}
	}
	
	

}



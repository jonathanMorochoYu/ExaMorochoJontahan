package Dato;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import Modelo.Universidad;

@Stateless
public class UniversidadDao {
	
	@PersistenceContext(name = "") 
	private EntityManager con;
	
	public boolean insertarPersona(Persona persona) {
		con.persist(persona);
		return true;
	}
	
	
	public Universidad obtenerbuscar2(String codigo) {
		 return con.find(Universidad.class, codigo);
	}
	
	public Universidad obtene2(String nom) {
		String jpql = "SELECT t FROM Persona t " 
				+ "WHERE t.nombre =:nombre";
		Query q = con.createQuery(jpql, Universidad.class);
		q.setParameter("nombre", nom);
		return (Universidad) q.getSingleResult();
		
	}
	
	public boolean editar_modelo(Universidad pers) {
		con.merge(pers);
		return true;
	}
	
	public List<Universidad> obtener() {
		String jpl = "select p from Persona p";
		Query q = con.createQuery(jpl, Universidad.class);
		//Query q = con.createNativeQuery(jpl, Persona.class) ;
		return q.getResultList();
	
	}
	
	public void eliminarpersona(Universidad per) {
		Universidad p = obtenerbuscar2(per.getCodigo());
		con.remove(p);

    }

	

}

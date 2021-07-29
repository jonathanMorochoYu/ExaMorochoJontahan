package view;

import java.util.List;

import javax.inject.Inject;

import Modelo.Universidad;
import Objeto.UniversidadOn;

public class UniversidadBean {
	
	
	private Universidad newUniversidad = new Universidad();
	private List<Universidad> universidades;
	@Inject
	private UniversidadOn universidadON;
	
	//@PostConstruct
	public void init() {
		universidades = universidadON.getUniversidad();
		System.out.println(universidades);
	}

	public Universidad getNewUniversidad() {
		return newUniversidad;
	}

	public void setNewUniversidad(Universidad newUniversidad) {
		this.newUniversidad = newUniversidad;
	}
	
	
	public String guardarUniversidad() {

		try {
			universidadON.insertUniversidad(newUniversidad);
			System.out.println("Universidad Insertado");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return "lista?faces-redirect=true";
	}
	
	

	public List<Universidad> getUniversidades() {
		return universidades;
	}

	public void setUniversidades(List<Universidad> universidades) {
		this.universidades = universidades;
	}
	

}

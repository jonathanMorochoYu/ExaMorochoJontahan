package view;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
//import javax.annotation.PostConstruct;
import Modelo.Carrera;
import Objeto.CarreraOn;


@Named
@RequestScoped
public class CarreraBean {

	private Carrera newCarrera = new Carrera();
	private List<Carrera> carreras;
	@Inject
	private CarreraOn carreraON;
	
	//@PostConstruct
	public void init() {
		carreras = carreraON.getCarreras();
		System.out.println(carreras);
	}

	public Carrera getNewCarrera() {
		return newCarrera;
	}

	public void setNewCarrera(Carrera newCarrera) {
		this.newCarrera = newCarrera;
	}
	
	
	public String guardarCarrera() {

		try {
			carreraON.insertCarrera(newCarrera);
			System.out.println("Carrera Universitaria");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return "lista?faces-redirect=true";
	}

	
	public List<Carrera> getCarreras() {
		return carreras;
	}

	public void setCarreras(List<Carrera> carreras) {
		this.carreras = carreras;
	}
	
}

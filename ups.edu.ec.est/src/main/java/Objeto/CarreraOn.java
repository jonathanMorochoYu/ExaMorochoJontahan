package Objeto;

import java.util.List;

import javax.inject.Inject;

import Dato.CarreraDao;
import Modelo.Carrera;

public class CarreraOn {
	
	@Inject

	private CarreraDao daoCarrera;

	public void insertCarrera(Carrera carrera) throws Exception {

		daoCarrera.insert(carrera);
	}

	public void updateCarrera(Carrera carrera) throws Exception {

		daoCarrera.update(carrera);
	}

	public void deleteCarrera(Carrera carrera) throws Exception {
		String com = String.valueOf(carrera.getCodigo());
		daoCarrera.delete(com);
	}

	public List<Carrera> getCarreras() {

		

		return daoCarrera.getCarreras("%");
	}

	public Carrera getCarrera(String car) {
		Carrera p = daoCarrera.read(car);
		return p;
	}


}

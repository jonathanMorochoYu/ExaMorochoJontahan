package Objeto;

import java.util.List;

import javax.inject.Inject;

import Dato.UniversidadDao;
import Modelo.Universidad;

public class UniversidadOn {
	@Inject
	private UniversidadDao daoUniversidad;

	public void insertUniversidad(Universidad universidad) throws Exception {

		daoUniversidad.insert(universidad);
	}

	public void updateUniversidad(Universidad universidad) throws Exception {

		daoUniversidad.update(universidad);
	}

	public void deleteUniversidad(Universidad universidad) throws Exception {
		String com = String.valueOf(universidad.getCodigo());
		daoUniversidad.delete(com);
	}

	public List<Universidad> getUniversidad() {

		

		return daoUniversidad.getUniversidades("%");
	}

	public Universidad getUniversidad(String car) {
		Universidad p = daoUniversidad.read(car);
		return p;
	}

}

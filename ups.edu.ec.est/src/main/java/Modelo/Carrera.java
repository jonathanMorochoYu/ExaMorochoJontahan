package Modelo;

import javax.persistence.Entity;

import Modelo.Column;
import Modelo.Id;


@Entity
public class Carrera {
	

	@Id

	private int  codigo;
	private String nombre;
	private String direccionCarrera;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccionCarrera() {
		return direccionCarrera;
	}
	public void setDireccionCarrera(String direccionCarrera) {
		this.direccionCarrera = direccionCarrera;
	}
	
	

}

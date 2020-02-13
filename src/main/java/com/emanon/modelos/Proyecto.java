package com.emanon.modelos;

public class Proyecto {
	
	private String nombre;
	private String descripcion;
	private int horas;
	
	
	public Proyecto() {}
	
	public Proyecto(String nombre, String descripcion, int horas) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.horas = horas;
	}
	
	
	
	@Override
	public String toString() {
		return "Proyecto [nombre=" + nombre + ", descripcion=" + descripcion + ", horas=" + horas + "]";
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	
	
}

package com.emanon.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;

@Entity
@Table(name="proyecto")
public class EntidadProyecto {
	
	@Id
	@GeneratedValue
	@Column(name="id_proyecto")
	private int id_proyecto;
	@Column(name="nombre")
	private String nombre;
	@Column(name="descripcion")
	private String descripcion;
	@Column(name="horas")
	private int horas;
	
	public EntidadProyecto() {
		super();
	}
	
	public EntidadProyecto(int id_proyecto, String nombre, String descripcion, int horas) {
		super();
		this.id_proyecto = id_proyecto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.horas = horas;
	}
	
	
	
	@Override
	public String toString() {
		return "Proyecto [id_proyecto=" + id_proyecto + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", horas=" + horas + "]";
	}

	public int getId_proyecto() {
		return id_proyecto;
	}
	public void setId_proyecto(int id_proyecto) {
		this.id_proyecto = id_proyecto;
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

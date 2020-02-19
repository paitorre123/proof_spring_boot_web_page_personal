package com.emanon.modelos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Usuario{
	
	@NotNull
	@Size(min=2, max=10)
	private String nombreUsuario;
	
	@NotNull
	@Size(min=8, max=14)
	private String clave;
	
	
	
	@Override
	public String toString() {
		return "Usuario [nombreUsuario=" + nombreUsuario + ", clave=" + clave + "]";
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	
}

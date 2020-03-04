package com.emanon.entidades;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuarioSesion")
public class UsuarioSesion {
	
	@Id
	@Column(name="username", unique = true, nullable = false, length = 45 )
	private String username;
	
	@Column(name = "clave", nullable = false, length = 60)
	private String clave;
	
	@Column(name = "disponible", nullable = false)
	private boolean disponible;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "usuarioSesion")
	private Set<UsuarioRol> usuarioRol = new HashSet<UsuarioRol>();
	
	
	public UsuarioSesion(String nombre, String clave, boolean disponible) {
		super();
		this.username = nombre;
		this.clave = clave;
		this.disponible = disponible;
	}
	
	
	public UsuarioSesion(String nombre, String clave, boolean disponible, Set<UsuarioRol> usuarioRol) {
		super();
		this.username = nombre;
		this.clave = clave;
		this.disponible = disponible;
		this.usuarioRol = usuarioRol;
	}
	
	public UsuarioSesion() {}
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public Set<UsuarioRol> getUsuarioRol() {
		return usuarioRol;
	}
	public void setUsuarioRol(Set<UsuarioRol> usuarioRol) {
		this.usuarioRol = usuarioRol;
	}
	
	
}

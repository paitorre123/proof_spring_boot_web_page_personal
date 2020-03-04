package com.emanon.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "usuarioRol", uniqueConstraints = @UniqueConstraint(
		columnNames = {"rol", "nombre"}
		))
public class UsuarioRol {
	@Id
	@GeneratedValue
	@Column(name = "id_rol", unique = true, nullable = false)
	private Integer idRol;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "nombre", nullable = false)
	private UsuarioSesion usuarioSesion;
	
	@Column(name = "rol",  nullable = false, length = 45)
	private String rol;
	
	public UsuarioRol(UsuarioSesion usuarioSesion, String rol) {
		super();
		this.usuarioSesion = usuarioSesion;
		this.rol = rol;
	}
	
	public UsuarioRol() {}


	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public UsuarioSesion getUsuarioSesion() {
		return usuarioSesion;
	}
	public void setUsuarioSesion(UsuarioSesion usuarioSesion) {
		this.usuarioSesion = usuarioSesion;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	
}

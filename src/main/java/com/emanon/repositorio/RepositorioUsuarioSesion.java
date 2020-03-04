package com.emanon.repositorio;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emanon.entidades.UsuarioSesion;

@Repository("repositorioUsuarioSesion")
public interface RepositorioUsuarioSesion extends JpaRepository<UsuarioSesion, Serializable>{
	
	public abstract UsuarioSesion findByUsername(String username);
}

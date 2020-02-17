package com.emanon.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emanon.entidades.EntidadProyecto;



@Repository("repositorioProyectos")
public interface RepositorioProyectos extends JpaRepository<EntidadProyecto, Integer>{
	
	
	//public abstract Proyecto buscarProyectoPorId(int id_proyecto);
	//public abstract Proyecto bucarProyectoPorNombre(String nomber);
	//public abstract List<Proyecto> buscarProyectosPorHoras(int horas);
}

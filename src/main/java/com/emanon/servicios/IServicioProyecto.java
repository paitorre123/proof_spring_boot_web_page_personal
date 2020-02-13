package com.emanon.servicios;

import java.util.List;

import com.emanon.entidades.EntidadProyecto;

public interface IServicioProyecto {
	
	public List<EntidadProyecto> listarTodosProyectos();
	public EntidadProyecto addProyecto(EntidadProyecto proyecto);
	public int removerProyecto(EntidadProyecto entidadProyecto);
	public EntidadProyecto modificarProyecto(EntidadProyecto proyecto);
	public EntidadProyecto getProyectoPorId(int id_priyecto);

}

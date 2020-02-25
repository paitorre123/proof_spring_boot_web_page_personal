package com.emanon.componentes;

import org.springframework.stereotype.Component;

import com.emanon.entidades.EntidadProyecto;
import com.emanon.modelos.Proyecto;

@Component("convertidorProyecto")
public class ConvertidorProyecto {
	
	public Proyecto proyectoDesdeEntidadAModelo(EntidadProyecto entidadProyecto) {
		Proyecto proyecto = new Proyecto();
		proyecto.setNombre(entidadProyecto.getNombre());
		proyecto.setDescripcion(entidadProyecto.getDescripcion());
		proyecto.setHoras(entidadProyecto.getHoras());
		return proyecto;
	}
	
	public EntidadProyecto proyectoDesdeModeloAEntidad( Proyecto proyecto ) {
		EntidadProyecto entidadProyecto = new EntidadProyecto();
		entidadProyecto.setNombre(proyecto.getNombre());
		entidadProyecto.setDescripcion(proyecto.getDescripcion());
		entidadProyecto.setHoras(proyecto.getHoras());
		return entidadProyecto;
	}
}

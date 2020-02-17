package com.emanon.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.emanon.entidades.EntidadProyecto;
import com.emanon.repositorio.RepositorioProyectos;

@Service("servicioDeProyectos")
public class ServicioDeProyectos implements IServicioProyecto{
	
	@Autowired
	@Qualifier("repositorioProyectos")
	private RepositorioProyectos repositorioProyectos;
	
	@Override
	public List<EntidadProyecto> listarTodosProyectos() {
		return (List<EntidadProyecto>) repositorioProyectos.findAll();
	}

	@Override
	public EntidadProyecto addProyecto(EntidadProyecto proyecto) {
		return repositorioProyectos.save(proyecto);
	}

	@Override
	public int removerProyecto(EntidadProyecto proyecto) {
		repositorioProyectos.delete(proyecto);
		return 0;
	}

	@Override
	public EntidadProyecto modificarProyecto(EntidadProyecto proyecto) {
		return repositorioProyectos.saveAndFlush(proyecto);
	}

	@Override
	public EntidadProyecto getProyectoPorId(int id_proyecto) {
		return repositorioProyectos.findById(id_proyecto).get();
	}

}

package com.emanon.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.emanon.modelos.Persona;

@Service("servicioDePersonas")
public class ServicioDePersonas implements IServicioPersona{

	@Override
	public List<Persona> getPersonas() {
		List<Persona> personas = new ArrayList<Persona>();
		personas.add(new Persona("Pablo", 25));
		personas.add(new Persona("Juan", 22));
		personas.add(new Persona("Pedro", 27));
		personas.add(new Persona("Ana", 18));
		return personas;
	}

}

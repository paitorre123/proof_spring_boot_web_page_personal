package com.emanon.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.emanon.model.Persona;
@Controller
@RequestMapping("/init")
public class ControladorInit {
	
	public static final String VIEW_HELLO = "hello";
	
	
	@GetMapping("/holaMundo")
	public String holaMundo(Model modelo) {
		modelo.addAttribute("personas", getPersonas());
		return VIEW_HELLO;
	}
	
	@GetMapping("/holaMundoMAV")
	public ModelAndView holaMundoMAV() {
		ModelAndView modelo = new ModelAndView(VIEW_HELLO);
		modelo.addObject("personas",getPersonas());
		return modelo;
	}
	
	private List<Persona> getPersonas(){
		List<Persona> personas = new ArrayList<Persona>();
		personas.add(new Persona("Pablo", 25));
		personas.add(new Persona("Juan", 22));
		personas.add(new Persona("Pedro", 27));
		personas.add(new Persona("Ana", 18));
		return personas;
	}
}

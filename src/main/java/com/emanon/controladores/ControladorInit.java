package com.emanon.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.emanon.model.Persona;
@Controller
@RequestMapping("/init")
public class ControladorInit {
	
	public static final String VIEW_HELLO = "hello2";
	
	
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
	
	@GetMapping("/request")
	public ModelAndView requestPorParametro(@RequestParam(name="nb", required = false, defaultValue = "No name") String nombre) {
		ModelAndView modelo = new ModelAndView(VIEW_HELLO);
		modelo.addObject("nombre_in_model",nombre);
		return modelo;
	}
	
	@GetMapping("/request/{nb}")
	public ModelAndView requestPorPath(@PathVariable("nb") String nombre) {
		ModelAndView modelo = new ModelAndView(VIEW_HELLO);
		modelo.addObject("nombre_in_model", nombre);
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

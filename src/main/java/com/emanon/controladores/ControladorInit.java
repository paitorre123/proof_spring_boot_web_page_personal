package com.emanon.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.emanon.servicios.IServicioPersona;
@Controller
@RequestMapping("/init")
public class ControladorInit {
	
	public static final String VIEW_HELLO_PERSON = "hello";
	public static final String VIEW_HELLO_NAME = "hello2";
	
	@Autowired
	@Qualifier("servicioDePersonas")
	private IServicioPersona servicioPersonas;
	
	@GetMapping("/holaMundo")
	public String holaMundo(Model modelo) {
		modelo.addAttribute("personas", servicioPersonas.getPersonas());
		return VIEW_HELLO_PERSON;
	}
	
	@GetMapping("/holaMundoMAV")
	public ModelAndView holaMundoMAV() {
		ModelAndView modelo = new ModelAndView(VIEW_HELLO_PERSON);
		modelo.addObject("personas", servicioPersonas.getPersonas());
		return modelo;
	}
	
	@GetMapping("/request")
	public ModelAndView requestPorParametro(@RequestParam(name="nb", required = false, defaultValue = "no-name") String nombre) {
		ModelAndView modelo = new ModelAndView(VIEW_HELLO_NAME);
		modelo.addObject("nombre_in_model",nombre);
		return modelo;
	}
	
	@GetMapping("/request/{nb}")
	public ModelAndView requestPorPath(@PathVariable("nb") String nombre) {
		ModelAndView modelo = new ModelAndView(VIEW_HELLO_NAME);
		modelo.addObject("nombre_in_model", nombre);
		return modelo;
	}
	
	
}

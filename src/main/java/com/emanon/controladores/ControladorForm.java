package com.emanon.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.emanon.model.Persona;

@Controller
@RequestMapping("/form")
public class ControladorForm {
	
	public static final String VIEW_FORM= "form";
	public static final String VIEW_RESULT_FORM= "resultForm";
	
	@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("/form/showForm");
	}
	
	
	
	@GetMapping("/showForm")
	public String showForm(Model modelo) {
		modelo.addAttribute("persona", new Persona());
		return VIEW_FORM;
	}
	
	@PostMapping("/addPersona")
	public ModelAndView addPersona(@ModelAttribute("persona") Persona persona) {
		ModelAndView modelo = new ModelAndView(VIEW_RESULT_FORM);
		modelo.addObject("persona", persona);
		System.out.println(persona.getNombre());
		System.out.println(persona.getEdad());
		return modelo;
	}
}

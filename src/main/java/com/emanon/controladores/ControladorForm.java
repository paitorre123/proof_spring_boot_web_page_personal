package com.emanon.controladores;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.emanon.modelos.Persona;

@Controller
@RequestMapping("/form")
public class ControladorForm {
	
	private static final Log LOGGER = LogFactory.getLog(ControladorForm.class);
	
	public static final String VIEW_FORM= "form";
	public static final String VIEW_RESULT_FORM= "resultForm";
	
	
	
	@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("/form/showForm");
	}
	
	@GetMapping("/showForm")
	public String showForm(Model modelo) {
		LOGGER.info("METHOD: 'showForm' -- PATH: '/form/showForm' -- TEMPLATE: '"+ VIEW_FORM + "'");
		modelo.addAttribute("persona", new Persona());
		return VIEW_FORM;
	}
	
	@PostMapping("/addPersona")
	public ModelAndView addPersona(@Valid @ModelAttribute("persona") Persona persona, BindingResult bindingResult) {
		LOGGER.info("METHOD: 'addPersona' -- PATH: '/form/addPersona' -- TEMPLATE: '"+ VIEW_RESULT_FORM + "' -- DATA: '" + persona + "'");
		ModelAndView modelo = new ModelAndView();;
		if(bindingResult.hasErrors()) {
			modelo.setViewName(VIEW_FORM);
		} else {
			modelo.setViewName(VIEW_RESULT_FORM);
			modelo.addObject("persona", persona);
		}
		
		
		return modelo;
	}
}

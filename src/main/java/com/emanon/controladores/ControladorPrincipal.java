package com.emanon.controladores;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.emanon.modelos.Usuario;

@Controller
public class ControladorPrincipal {
	
	public static String LOGIN_VIEW = "login";
	public static String CONTACTS_VIWE = "contacts";
	
	@GetMapping(value= {"", "/", "/index"})
	public String index() {
		return "redirect:/showLogin";
	}
	
	@GetMapping("/showLogin")
	public ModelAndView showLogin() {
		ModelAndView model = new ModelAndView(LOGIN_VIEW);
		model.addObject("usuario", new Usuario());
		return model;
	}
	@PostMapping("/login")
	public ModelAndView login(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult bindingResult) {
		ModelAndView model = new ModelAndView();
		if(!bindingResult.hasErrors() && (usuario.getNombreUsuario().equals("usuario") && usuario.getClave().equals("12345678")) ) {
			model.setViewName(CONTACTS_VIWE);
		} else {
			model.setViewName(LOGIN_VIEW);
		}
		return model;
	}
}	

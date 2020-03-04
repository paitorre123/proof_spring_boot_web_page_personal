package com.emanon.controladores;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.emanon.modelos.CredencialUsuario;

@Controller
public class ControladorPrincipal {
	
	private static final String LOGIN_VIEW = "login";
	
	private static final Log LOG = LogFactory.getLog(ControladorPrincipal.class);
	

	
	@GetMapping("/login")
	public ModelAndView showLogin(  @RequestParam(name="error", required = false) String error,
									@RequestParam(name="logout", required = false) String logout) {
		LOG.info("METODO : showLogin() -- PARAMETROS: error="+ error + ", logout="+ logout );
		ModelAndView model = new ModelAndView(LOGIN_VIEW);
		model.addObject("usuario", new CredencialUsuario());
		model.addObject("error", error);
		model.addObject("logout", logout);
		LOG.info("Retorno a vista /login");
		return model;
	}
	@GetMapping({"/loginsuccess", "/"})
	public String loginCheck() {
		
		return "redirect:/proyecto/listadoProyectos";
	}
}	

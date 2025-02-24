package com.emanon.controladores;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.emanon.componentes.ConvertidorProyecto;
import com.emanon.entidades.EntidadProyecto;
import com.emanon.modelos.Proyecto;
import com.emanon.servicios.ServicioDeProyectos;

@Controller
@RequestMapping("/proyecto")
public class ControladorProyectos {
	
	private static final Log LOG = LogFactory.getLog(ControladorProyectos.class);
	
	 private static final String PROYECTOS_VIEW = "proyectos";
	 private static final String FORMULARIO_PROYECTO_VIEW = "formularioProyecto";
	 
	 @Autowired
	 @Qualifier("servicioDeProyectos")
	 private ServicioDeProyectos servicioDeProyectos;
	 
	 @Autowired
	 @Qualifier("convertidorProyecto")
	 private ConvertidorProyecto convertidorProyecto;
	 
	 @GetMapping("/showFormularioProyecto")
	 public String showFormularioProyecto(Model model) {
		 LOG.info("URL: /proyecto/showFormularioProyecto -- CALL: showFormularioProyecto() -- VIEW: "+ FORMULARIO_PROYECTO_VIEW );
		 model.addAttribute("proyecto", new EntidadProyecto());
		 return FORMULARIO_PROYECTO_VIEW;
	 }
	 
	 @GetMapping("/cancelar")
	 public String cancelar() {
		 return "redirect:/proyecto/listadoProyectos";
	 }
	 
	 @GetMapping("/listadoProyectos")
	 public ModelAndView listarTodosProyectos() {
		 LOG.info("URL: /proyecto/listadoProyectos -- CALL: listarTodosProyectos() " );
		 ModelAndView model = new ModelAndView(PROYECTOS_VIEW);
		 model.addObject("proyectos", servicioDeProyectos.listarTodosProyectos());
		 model.addObject("proyecto", new EntidadProyecto());
		 return model;
	 }
	 
	 @PostMapping("/addProyecto")
	 public String addProyecto(@ModelAttribute("proyecto") EntidadProyecto proyecto) {
		 LOG.info("URL: /proyecto/addProyecto -- CALL: addProyecto() PARAM: "+ proyecto.toString());
		 servicioDeProyectos.addProyecto(proyecto);
		 return "redirect:/proyecto/listadoProyectos";
	 }
	 
	 @GetMapping("/removeProyecto/{id_proyecto}")
	 public String removeProyecto(@PathVariable("id_proyecto") int id_proyecto) {
		 
		 EntidadProyecto entidad_proyecto = servicioDeProyectos.getProyectoPorId(id_proyecto);
		 
		 LOG.info("URL: /proyecto/removeProyecto -- ENTIDAD: : "+ entidad_proyecto.toString());
		 servicioDeProyectos.removerProyecto(entidad_proyecto);
		 return "redirect:/proyecto/listadoProyectos";
	 }
	 
	 @GetMapping("/modificarProyecto/{id_proyecto}")
	 public String modificarProyecto(@PathVariable("id_proyecto") int id_proyecto,  Model model) {
		 LOG.info("URL: /proyecto/updateProyecto -- CALL: updateProyecto() PARAM: "+ id_proyecto);
		 model.addAttribute("proyecto", servicioDeProyectos.getProyectoPorId(id_proyecto));
		 return FORMULARIO_PROYECTO_VIEW;
	 }
	 
	 @PostMapping(value="/json/search", produces = MediaType.APPLICATION_JSON_VALUE)
	 @ResponseBody
	 public List<EntidadProyecto>findAll(){
		 return servicioDeProyectos.listarTodosProyectos();
	 }
	 
}

package com.emanon.controladores;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.emanon.converter.ConvertidorProyecto;
import com.emanon.entidades.EntidadProyecto;
import com.emanon.modelos.Proyecto;
import com.emanon.servicios.ServicioDeProyectos;

@Controller
@RequestMapping("/proyecto")
public class ControladorProyectos {
	
	private static final Log LOG = LogFactory.getLog(ControladorProyectos.class);
	
	 private static final String PROYECTOS_VIEW = "proyectos_spa";
	 
	 @Autowired
	 @Qualifier("servicioDeProyectos")
	 private ServicioDeProyectos servicioDeProyectos;
	 
	 @Autowired
	 @Qualifier("convertidorProyecto")
	 private ConvertidorProyecto convertidorProyecto;
	 
	 
	 @GetMapping("/listadoProyectos")
	 public ModelAndView listarTodosProyectos() {
		 LOG.info("URL: /proyecto/listadoProyectos -- CALL: listarTodosProyectos() " );
		 ModelAndView model = new ModelAndView(PROYECTOS_VIEW);
		 model.addObject("proyectos", servicioDeProyectos.listarTodosProyectos());
		 model.addObject("proyecto", new EntidadProyecto());
		 return model;
	 }
	 
	 @PostMapping("/addProyecto")
	 public String addProyecto(@ModelAttribute("proyecto") Proyecto proyecto) {
		 LOG.info("URL: /proyecto/addProyecto -- CALL: addProyecto() PARAM: "+ proyecto.toString());
		 servicioDeProyectos.addProyecto(convertidorProyecto.proyectoDesdeModeloAEntidad(proyecto));
		 return "redirect:/proyecto/listadoProyectos";
	 }
	 
	 @GetMapping("/removeProyecto/{id_proyecto}")
	 public String removeProyecto(@PathVariable("id_proyecto") int id_proyecto) {
		 
		 EntidadProyecto entidad_proyecto = servicioDeProyectos.getProyectoPorId(id_proyecto);
		 
		 LOG.info("URL: /proyecto/removeProyecto -- ENTIDAD: : "+ entidad_proyecto.toString());
		 servicioDeProyectos.removerProyecto(entidad_proyecto);
		 return "redirect:/proyecto/listadoProyectos";
	 }
	 
	 @PostMapping("/updateProyecto")
	 public String updateProyecto(@ModelAttribute("proyecto_iterable") Proyecto proyecto) {
		 LOG.info("URL: /proyecto/updateProyecto -- CALL: updateProyecto() PARAM: "+ proyecto.toString());
		 servicioDeProyectos.modificarProyecto(convertidorProyecto.proyectoDesdeModeloAEntidad(proyecto));
		 return "redirect:/proyecto/listadoProyectos";
	 }
	 
	 @PostMapping(value="/json/search", produces = "application/json")
	 @ResponseBody
	 public List<EntidadProyecto>findAll(){
		 return servicioDeProyectos.listarTodosProyectos();
	 }
	 
}

package com.dawes.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.RecoleccionVO;
import com.dawes.servicios.ServicioFinca;
import com.dawes.servicios.ServicioRecoleccion;
import com.dawes.servicios.ServicioVariedad;

@Controller
@RequestMapping("/recolecciones")
public class RecoleccionController {
@Autowired
ServicioRecoleccion sr;
@Autowired
ServicioFinca sf;
@Autowired
ServicioVariedad sv;
@RequestMapping("/recoleccionesmostrar")
public String mostrar(Model modelo) {
	modelo.addAttribute("recolecciones",sr.findAll());
	return "recoleccion/recoleccionesmostrar";
}
@RequestMapping("/forminsertar")
public String forminsertar(Model modelo) {
	modelo.addAttribute("recoleccion", new RecoleccionVO());
	modelo.addAttribute("variedades",sv.findAll());
	modelo.addAttribute("fincas",sf.findAll());
	return "recoleccion/forminsertar";
}
@RequestMapping("/insertar")
public String Insertar(@ModelAttribute RecoleccionVO recoleccion, Model modelo) {
	sr.save(recoleccion);
	modelo.addAttribute("recolecciones",sr.findAll());
	return "recoleccion/recoleccionesmostrar";
	
}
@RequestMapping("/eliminar")
public String Eliminar (@RequestParam("idrecoleccion") int idrecoleccion, Model modelo) {
	sr.deleteById(idrecoleccion);
	modelo.addAttribute("recolecciones",sr.findAll());
	return "recoleccion/recoleccionesmostrar";
}
@RequestMapping("/formmodificar")
public String formmodificar(@RequestParam("idrecoleccion") int idrecoleccion,Model modelo) {
	modelo.addAttribute("recoleccion", sr.findById(idrecoleccion).get());
	modelo.addAttribute("variedades",sv.findAll());
	modelo.addAttribute("fincas",sf.findAll());
	return "recoleccion/formmodificar";
}
}

package com.dawes.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.FotoVO;
import com.dawes.modelo.ReposicionVO;
import com.dawes.servicios.ServicioArbol;
import com.dawes.servicios.ServicioFinca;
import com.dawes.servicios.ServicioReposicion;
import com.dawes.servicios.ServicioVariedad;

@Controller
@RequestMapping("/reposiciones")
public class ReposicionController {
	@Autowired
	ServicioReposicion sr;
	@Autowired
	ServicioArbol sa;
	@Autowired
	ServicioFinca sf;
	@Autowired
	ServicioVariedad sv;
	@RequestMapping("/reposicionesmostrar")
	public String mostrar(Model modelo) {
		modelo.addAttribute("reposiciones",sr.findAll());
		return "reposicion/reposicionesmostrar";
	}
	@RequestMapping("/forminsertar")
	public String forminsertar(Model modelo,@RequestParam("idarbol") int idarbol) {
		ReposicionVO reposicion = new ReposicionVO();
		reposicion.setArbol(sa.findById(idarbol).get());
		modelo.addAttribute("reposicion", reposicion);
		modelo.addAttribute("arboles", sa.findAll());
		return "reposicion/forminsertar";
	}
	@RequestMapping("/insertar")
	public String Insertar(@ModelAttribute ReposicionVO reposicion, Model modelo) {
		sr.save(reposicion);
		modelo.addAttribute("arbol", reposicion.getArbol());
		modelo.addAttribute("fincas", sf.findAll());
		modelo.addAttribute("variedades", sv.findAll());
		return "arbol/formmodificar";
	}
	@RequestMapping("/eliminar")
	public String Eliminar (@RequestParam("idreposicion") int idreposicion, Model modelo) {
		sr.deleteById(idreposicion);
		modelo.addAttribute("reposiciones",sr.findAll());
		return "reposicion/reposicionesmostrar";
	}
	@RequestMapping("/formmodificar")
	public String formmodificar(@RequestParam("idreposicion") int idreposicion,Model modelo) {
		modelo.addAttribute("reposicion", sr.findById(idreposicion).get());
		modelo.addAttribute("arboles", sa.findAll());
		return "reposicion/formmodificar";
	}
}

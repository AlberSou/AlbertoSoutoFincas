package com.dawes.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.ArbolVO;
import com.dawes.servicios.ServicioArbol;
import com.dawes.servicios.ServicioFinca;
import com.dawes.servicios.ServicioFoto;
import com.dawes.servicios.ServicioReposicion;
import com.dawes.servicios.ServicioTratamiento;
import com.dawes.servicios.ServicioVariedad;

@Controller
@RequestMapping("/arboles")
public class ArbolController {
@Autowired
ServicioArbol sa;
@Autowired
ServicioFinca sf;
@Autowired
ServicioVariedad sv;
@Autowired
ServicioTratamiento st;
@Autowired
ServicioFoto sfo;
@Autowired
ServicioReposicion sr;

@RequestMapping("/arbolesmostrar")
public String mostrar(Model modelo) {
	modelo.addAttribute("arboles",sa.findAll());
	return "/arbol/arbolesmostrar";
}
@RequestMapping("/forminsertar")
public String forminsertar(Model modelo,@RequestParam("idfinca") int idfinca) {
	ArbolVO arbol = new ArbolVO();
	arbol.setFinca(sf.findById(idfinca).get());
	modelo.addAttribute("arbol", arbol);
	modelo.addAttribute("arbolv", arbol);
	modelo.addAttribute("fincas", sf.findAll());
	modelo.addAttribute("variedades", sv.findAll());
	return "/arbol/forminsertar";
}
@RequestMapping("/planoforminsertar")
public String planoforminsertar(@RequestParam("filax") int fila,@RequestParam("columnax")int columna, @RequestParam("idfincax") int idfinca, Model modelo) {
	ArbolVO a=new ArbolVO();
	a.setFila(fila);
	a.setColumna(columna);
	a.setFinca(sf.findById(idfinca).get());
	modelo.addAttribute("arbol", a);
	modelo.addAttribute("fincas", sf.findAll());
	modelo.addAttribute("variedades", sv.findAll());
	return "/arbol/formmodificar";
}
@RequestMapping("/insertar")
public String Insertar(@ModelAttribute ArbolVO arbol, Model modelo) {
	sa.save(arbol);
	modelo.addAttribute("finca",sf.findById(arbol.getFinca().getIdfinca()).get());
	modelo.addAttribute("arboles",sa.findAllByFinca(sf.findById(arbol.getFinca().getIdfinca()).get()) );
	return "/arbol/arbolesmostrar";
	
}
@RequestMapping("/eliminar")
public String Eliminar (@RequestParam("idarbol") int idarbol,@RequestParam("idfinca") int idfinca, Model modelo) {
	sa.deleteById(idarbol);
	modelo.addAttribute("arboles",sa.findAllByFinca(sf.findById(idfinca).get()) );
	return "/arbol/arbolesmostrar";
}
@RequestMapping("/formmodificar")
public String formmodificar(@RequestParam("idarbol") int idarbol,Model modelo) {
	modelo.addAttribute("arbol", sa.findById(idarbol).get());
	modelo.addAttribute("fincas", sf.findAll());
	modelo.addAttribute("variedades", sv.findAll());
	return "/arbol/formmodificar";
}

@RequestMapping("/arboltratamientos")
public String arboltratamientos(@RequestParam("idarbol") int idarbol,Model modelo) {
	modelo.addAttribute("arbol", sa.findById(idarbol).get());
	modelo.addAttribute("tratamientos",st.findAllByArbol(sa.findById(idarbol).get()) );
	return "/arbol/tratamientosmostrar";
}
@RequestMapping("/arbolfotos")
public String arbolfotos(@RequestParam("idarbol") int idarbol,Model modelo) {
	modelo.addAttribute("arbol", sa.findById(idarbol).get());
	modelo.addAttribute("fotos",sfo.findAllByArbol(sa.findById(idarbol).get()) );
	return "/foto/fotosmostrar";
}
@RequestMapping("/arbolreposiciones")
public String arbolreposiciones(@RequestParam("idarbol") int idarbol,Model modelo) {
	modelo.addAttribute("arbol", sa.findById(idarbol).get());
	modelo.addAttribute("reposiciones",sr.findAllByArbol(sa.findById(idarbol).get()) );
	return "/reposicion/reposicionesmostrar";
}
}

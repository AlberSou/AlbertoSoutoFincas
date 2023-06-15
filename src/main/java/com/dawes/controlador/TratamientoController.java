package com.dawes.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.FotoVO;
import com.dawes.modelo.TratamientoVO;
import com.dawes.servicios.ServicioArbol;
import com.dawes.servicios.ServicioTratamiento;

@Controller
@RequestMapping("/tratamientos")
public class TratamientoController {
@Autowired
ServicioTratamiento st;
@Autowired
ServicioArbol sa;
@RequestMapping("/tratamientosmostrar")
public String mostrar(Model modelo) {
	modelo.addAttribute("tratamientos",st.findAll());
	return "tratamiento/tratamientosmostrar";
}
@RequestMapping("/forminsertar")
public String forminsertar(Model modelo) {
	modelo.addAttribute("tratamiento", new TratamientoVO());
	modelo.addAttribute("arboles", sa.findAll());
	return "tratamiento/forminsertar";
}
@RequestMapping("/forminsertararbol")
public String forminsertararbol(Model modelo,@RequestParam("idarbol") int idarbol) {
	TratamientoVO tratamiento = new TratamientoVO();
	tratamiento.setArbol(sa.findById(idarbol).get());
	modelo.addAttribute("tratamiento", tratamiento);
	modelo.addAttribute("arboles", sa.findAll());
	modelo.addAttribute("arbol", sa.findById(idarbol).get());
	return "tratamiento/forminsertararbol";
}
@RequestMapping("/insertar")
public String Insertar(@ModelAttribute TratamientoVO tratamiento, Model modelo) {
	st.save(tratamiento);
	modelo.addAttribute("tratamientos",st.findAll());
	
	return "tratamiento/tratamientosmostrar";
	
}
@RequestMapping("/insertararbol")
public String Insertararbol(@ModelAttribute TratamientoVO tratamiento, Model modelo) {
	st.save(tratamiento);
	modelo.addAttribute("tratamientos",st.findAllByArbol(tratamiento.getArbol()));
	modelo.addAttribute("arbol",tratamiento.getArbol());
	return "tratamiento/tratamientosmostrararbol";
	
}
@RequestMapping("/eliminar")
public String Eliminar (@RequestParam("idtratamiento") int idtratamiento, Model modelo) {
	st.deleteById(idtratamiento);
	modelo.addAttribute("tratamientos",st.findAll());
	
	return "tratamiento/tratamientosmostrar";
}
@RequestMapping("/eliminararbol")
public String Eliminararbol (@RequestParam("idtratamiento") int idtratamiento, Model modelo,@RequestParam("idarbol") int idarbol) {
	st.deleteById(idtratamiento);
	modelo.addAttribute("tratamientos",st.findAllByArbol(sa.findById(idarbol).get()));
	modelo.addAttribute("arbol",sa.findById(idarbol).get());

	return "tratamiento/tratamientosmostrararbol";
}
@RequestMapping("/formmodificar")
public String formmodificar(@RequestParam("idtratamiento") int idtratamiento,Model modelo) {
	modelo.addAttribute("tratamiento", st.findById(idtratamiento).get());
	modelo.addAttribute("arboles", sa.findAll());
	return "tratamiento/formmodificar";
}
}

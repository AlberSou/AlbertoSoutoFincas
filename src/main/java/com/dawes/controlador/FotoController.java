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
import com.dawes.servicios.ServicioFoto;

@Controller
@RequestMapping("/fotos")
public class FotoController {
@Autowired
ServicioFoto sf;
@Autowired
ServicioArbol sa;
@RequestMapping("/fotosmostrar")
public String mostrar(Model modelo,@RequestParam("idarbol") int idarbol) {
	modelo.addAttribute("/fotos",sf.findAllByArbol(sa.findById(idarbol).get()));
	modelo.addAttribute("arbol",sa.findById(idarbol).get());
	return "/foto/fotosmostrar";
}
@RequestMapping("/forminsertar")
public String forminsertar(Model modelo, @RequestParam("idarbol") int idarbol) {
	FotoVO foto = new FotoVO();
	foto.setArbol(sa.findById(idarbol).get());
	modelo.addAttribute("foto", foto);
	modelo.addAttribute("arboles", sa.findAll());
	return "/foto/forminsertar";
}
@RequestMapping("/insertar")
public String Insertar(@ModelAttribute FotoVO foto, Model modelo) {
	sf.save(foto);
	modelo.addAttribute("fotos",sf.findAll());
	modelo.addAttribute("arbol",foto.getArbol());
	return "/foto/fotosmostrar";
	
}
@RequestMapping("/eliminar")
public String Eliminar (@RequestParam("idfoto") int idfoto, Model modelo) {
	sf.deleteById(idfoto);
	modelo.addAttribute("fotos",sf.findAll());
	return "/foto/fotosmostrar";
}
@RequestMapping("/formmodificar")
public String formmodificar(@RequestParam("idfoto") int idfoto,Model modelo) {
	modelo.addAttribute("foto", sf.findById(idfoto).get());
	modelo.addAttribute("arboles", sa.findAll());
	return "/foto/formmodificar";
}
}

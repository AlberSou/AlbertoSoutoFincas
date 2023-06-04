package com.dawes.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dawes.modelo.FincaVO;
import com.dawes.servicios.ServicioFinca;

import jakarta.servlet.http.HttpServletRequest;
@Controller
public class controladorPrincipal {
	@Autowired
	ServicioFinca sf;
	@RequestMapping("/principal")
	public String index() {
		return "index";
	}
	@RequestMapping("/admin")
	public String administrador() {
		return "admin/admin";
	}
	@RequestMapping("/user")
	public String user() {
		return "user/user";
	}
	@RequestMapping("/403")
	public String p403() {
		return "403";
	}
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/salir")
	public String salir(HttpServletRequest request, Model modelo) {
		request.getSession(true).invalidate();
		modelo.addAttribute("fincas",sf.findAll());
		return "index";
	}

}

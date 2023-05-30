package com.dawes.serviciosimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dawes.modelo.UsuarioVO;
import com.dawes.repositorio.UsuarioRepositorio;

@Service
public class ServicioUsuarioImpl implements UserDetailsService {
	@Autowired
	UsuarioRepositorio ur;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return ur.findByUsername(username);
	}
	public void saveUser(UsuarioVO usuario) {
		usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
		ur.save(usuario);
	}
	
	
}

package com.dawes.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.UsuarioVO;
@Repository
public interface UsuarioRepositorio extends CrudRepository<UsuarioVO, Integer> {
	UserDetails findByUsername(String nombre);
	
}

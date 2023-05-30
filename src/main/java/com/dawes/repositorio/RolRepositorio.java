package com.dawes.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.UsuarioVO;
@Repository
public interface RolRepositorio extends CrudRepository<UsuarioVO, Integer> {

}

package com.dawes.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.RecoleccionVO;
@Repository
public interface RecoleccionRepositorio extends CrudRepository<RecoleccionVO, Integer> {
	
}

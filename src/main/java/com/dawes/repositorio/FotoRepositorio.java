package com.dawes.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.ArbolVO;
import com.dawes.modelo.FotoVO;
@Repository
public interface FotoRepositorio extends CrudRepository<FotoVO, Integer>{
	List<FotoVO> findAllByArbol(ArbolVO arbol);

}

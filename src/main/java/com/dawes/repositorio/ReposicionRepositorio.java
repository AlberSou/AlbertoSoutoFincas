package com.dawes.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.ArbolVO;
import com.dawes.modelo.FotoVO;
import com.dawes.modelo.ReposicionVO;
@Repository
public interface ReposicionRepositorio extends CrudRepository<ReposicionVO, Integer>{
	List<ReposicionVO> findAllByArbol(ArbolVO arbol);

}

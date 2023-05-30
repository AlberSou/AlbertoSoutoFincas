package com.dawes.servicios;

import java.util.List;
import java.util.Optional;

import com.dawes.modelo.ArbolVO;
import com.dawes.modelo.FotoVO;

public interface ServicioFoto {

	List<FotoVO> findAllByArbol(ArbolVO arbol);

	<S extends FotoVO> S save(S entity);

	<S extends FotoVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<FotoVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<FotoVO> findAll();

	Iterable<FotoVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(FotoVO entity);

	void deleteAllById(Iterable<? extends Integer> ids);

	void deleteAll(Iterable<? extends FotoVO> entities);

	void deleteAll();

}
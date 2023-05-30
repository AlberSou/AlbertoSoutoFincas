package com.dawes.servicios;

import java.util.List;
import java.util.Optional;

import com.dawes.modelo.ArbolVO;
import com.dawes.modelo.ReposicionVO;

public interface ServicioReposicion {

	List<ReposicionVO> findAllByArbol(ArbolVO arbol);

	<S extends ReposicionVO> S save(S entity);

	<S extends ReposicionVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<ReposicionVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<ReposicionVO> findAll();

	Iterable<ReposicionVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(ReposicionVO entity);

	void deleteAllById(Iterable<? extends Integer> ids);

	void deleteAll(Iterable<? extends ReposicionVO> entities);

	void deleteAll();

}
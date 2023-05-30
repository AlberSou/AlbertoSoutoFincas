package com.dawes.servicios;

import java.util.Optional;

import com.dawes.modelo.VariedadVO;

public interface ServicioVariedad {

	Optional<VariedadVO> findByNombre(String nombre);

	<S extends VariedadVO> S save(S entity);

	<S extends VariedadVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<VariedadVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<VariedadVO> findAll();

	Iterable<VariedadVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(VariedadVO entity);

	void deleteAllById(Iterable<? extends Integer> ids);

	void deleteAll(Iterable<? extends VariedadVO> entities);

	void deleteAll();

}
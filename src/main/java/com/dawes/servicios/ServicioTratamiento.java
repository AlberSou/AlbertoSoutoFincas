package com.dawes.servicios;

import java.util.List;
import java.util.Optional;

import com.dawes.modelo.ArbolVO;
import com.dawes.modelo.TratamientoVO;

public interface ServicioTratamiento {

	Optional<TratamientoVO> findByDenominacion(String denominacion);

	List<TratamientoVO> findAllByArbol(ArbolVO arbol);

	<S extends TratamientoVO> S save(S entity);

	<S extends TratamientoVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<TratamientoVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<TratamientoVO> findAll();

	Iterable<TratamientoVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(TratamientoVO entity);

	void deleteAllById(Iterable<? extends Integer> ids);

	void deleteAll(Iterable<? extends TratamientoVO> entities);

	void deleteAll();

}
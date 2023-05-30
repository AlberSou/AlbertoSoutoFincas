package com.dawes.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.ArbolVO;
import com.dawes.modelo.FincaVO;
import com.dawes.modelo.TratamientoVO;
@Repository
public interface TratamientoRepositorio extends CrudRepository<TratamientoVO, Integer> {
	@Query("select t from TratamientoVO t where t.denominacion=?1")
	Optional<TratamientoVO> findByDenominacion(String denominacion);
	List<TratamientoVO> findAllByArbol(ArbolVO arbol);
}

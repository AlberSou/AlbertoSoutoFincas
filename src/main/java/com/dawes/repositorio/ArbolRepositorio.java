package com.dawes.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.ArbolVO;
import com.dawes.modelo.FincaVO;
@Repository
public interface ArbolRepositorio extends CrudRepository<ArbolVO, Integer>{
	Optional<ArbolVO> findByFilaAndColumnaAndFinca(int fila, int columna, FincaVO finca);
	List<ArbolVO> findAllByFinca(FincaVO finca);

}

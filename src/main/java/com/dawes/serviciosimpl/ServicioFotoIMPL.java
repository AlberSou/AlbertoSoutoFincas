package com.dawes.serviciosimpl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.ArbolVO;
import com.dawes.modelo.FotoVO;
import com.dawes.repositorio.FotoRepositorio;
import com.dawes.servicios.ServicioFoto;



@Service
public class ServicioFotoIMPL implements ServicioFoto  {
@Autowired
FotoRepositorio fr;

@Override
public List<FotoVO> findAllByArbol(ArbolVO arbol) {
	return fr.findAllByArbol(arbol);
}

@Override
public <S extends FotoVO> S save(S entity) {
	return fr.save(entity);
}

@Override
public <S extends FotoVO> Iterable<S> saveAll(Iterable<S> entities) {
	return fr.saveAll(entities);
}

@Override
public Optional<FotoVO> findById(Integer id) {
	return fr.findById(id);
}

@Override
public boolean existsById(Integer id) {
	return fr.existsById(id);
}

@Override
public Iterable<FotoVO> findAll() {
	return fr.findAll();
}

@Override
public Iterable<FotoVO> findAllById(Iterable<Integer> ids) {
	return fr.findAllById(ids);
}

@Override
public long count() {
	return fr.count();
}

@Override
public void deleteById(Integer id) {
	fr.deleteById(id);
}

@Override
public void delete(FotoVO entity) {
	fr.delete(entity);
}

@Override
public void deleteAllById(Iterable<? extends Integer> ids) {
	fr.deleteAllById(ids);
}

@Override
public void deleteAll(Iterable<? extends FotoVO> entities) {
	fr.deleteAll(entities);
}

@Override
public void deleteAll() {
	fr.deleteAll();
}



}

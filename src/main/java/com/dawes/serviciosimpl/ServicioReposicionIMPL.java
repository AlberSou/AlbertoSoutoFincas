package com.dawes.serviciosimpl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.ArbolVO;
import com.dawes.modelo.FotoVO;
import com.dawes.modelo.ReposicionVO;
import com.dawes.repositorio.ReposicionRepositorio;
import com.dawes.servicios.ServicioFoto;
import com.dawes.servicios.ServicioReposicion;



@Service
public class ServicioReposicionIMPL implements ServicioReposicion  {
@Autowired
ReposicionRepositorio rr;

@Override
public List<ReposicionVO> findAllByArbol(ArbolVO arbol) {
	return rr.findAllByArbol(arbol);
}

@Override
public <S extends ReposicionVO> S save(S entity) {
	return rr.save(entity);
}

@Override
public <S extends ReposicionVO> Iterable<S> saveAll(Iterable<S> entities) {
	return rr.saveAll(entities);
}

@Override
public Optional<ReposicionVO> findById(Integer id) {
	return rr.findById(id);
}

@Override
public boolean existsById(Integer id) {
	return rr.existsById(id);
}

@Override
public Iterable<ReposicionVO> findAll() {
	return rr.findAll();
}

@Override
public Iterable<ReposicionVO> findAllById(Iterable<Integer> ids) {
	return rr.findAllById(ids);
}

@Override
public long count() {
	return rr.count();
}

@Override
public void deleteById(Integer id) {
	rr.deleteById(id);
}

@Override
public void delete(ReposicionVO entity) {
	rr.delete(entity);
}

@Override
public void deleteAllById(Iterable<? extends Integer> ids) {
	rr.deleteAllById(ids);
}

@Override
public void deleteAll(Iterable<? extends ReposicionVO> entities) {
	rr.deleteAll(entities);
}

@Override
public void deleteAll() {
	rr.deleteAll();
}




}

package com.dawes.serviciosimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.dawes.modelo.UsuarioVO;
import com.dawes.repositorio.RolRepositorio;

public class ServicioRolIMPL {
@Autowired
RolRepositorio rr;

public <S extends UsuarioVO> S save(S entity) {
	return rr.save(entity);
}

public <S extends UsuarioVO> Iterable<S> saveAll(Iterable<S> entities) {
	return rr.saveAll(entities);
}

public Optional<UsuarioVO> findById(Integer id) {
	return rr.findById(id);
}

public boolean existsById(Integer id) {
	return rr.existsById(id);
}

public Iterable<UsuarioVO> findAll() {
	return rr.findAll();
}

public Iterable<UsuarioVO> findAllById(Iterable<Integer> ids) {
	return rr.findAllById(ids);
}

public long count() {
	return rr.count();
}

public void deleteById(Integer id) {
	rr.deleteById(id);
}

public void delete(UsuarioVO entity) {
	rr.delete(entity);
}

public void deleteAllById(Iterable<? extends Integer> ids) {
	rr.deleteAllById(ids);
}

public void deleteAll(Iterable<? extends UsuarioVO> entities) {
	rr.deleteAll(entities);
}

public void deleteAll() {
	rr.deleteAll();
}
}

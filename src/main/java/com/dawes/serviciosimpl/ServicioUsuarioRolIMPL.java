package com.dawes.serviciosimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.dawes.modelo.UsuarioRolVO;
import com.dawes.repositorio.UsuarioRolRepositorio;

public class ServicioUsuarioRolIMPL {
@Autowired
UsuarioRolRepositorio urr;

public <S extends UsuarioRolVO> S save(S entity) {
	return urr.save(entity);
}

public <S extends UsuarioRolVO> Iterable<S> saveAll(Iterable<S> entities) {
	return urr.saveAll(entities);
}

public Optional<UsuarioRolVO> findById(Integer id) {
	return urr.findById(id);
}

public boolean existsById(Integer id) {
	return urr.existsById(id);
}

public Iterable<UsuarioRolVO> findAll() {
	return urr.findAll();
}

public Iterable<UsuarioRolVO> findAllById(Iterable<Integer> ids) {
	return urr.findAllById(ids);
}

public long count() {
	return urr.count();
}

public void deleteById(Integer id) {
	urr.deleteById(id);
}

public void delete(UsuarioRolVO entity) {
	urr.delete(entity);
}

public void deleteAllById(Iterable<? extends Integer> ids) {
	urr.deleteAllById(ids);
}

public void deleteAll(Iterable<? extends UsuarioRolVO> entities) {
	urr.deleteAll(entities);
}

public void deleteAll() {
	urr.deleteAll();
}
}

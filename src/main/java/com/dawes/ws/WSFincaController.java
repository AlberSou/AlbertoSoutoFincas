package com.dawes.ws;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dawes.modelo.ArbolVO;
import com.dawes.modelo.FincaVO;
import com.dawes.servicios.ServicioArbol;
import com.dawes.servicios.ServicioFinca;

@RestController
public class WSFincaController {
@Autowired
ServicioFinca sf;
@Autowired
ServicioArbol sa;

@GetMapping("/getfincas")
public ResponseEntity<?> getFincas(){
	List<FincaVO> fincas = (List<FincaVO>) sf.findAll();
	return new ResponseEntity<List<FincaVO>>(fincas, HttpStatus.OK);

}
@PostMapping("/modArbol/{idfinca}/{fila}/{columna}/{ubicacion}")
public ResponseEntity<?> modArbol(@PathVariable int idfinca, @PathVariable int fila, @PathVariable int columna, @PathVariable String ubicacion){
FincaVO finca = sf.findById(idfinca).get();
ArbolVO arbol = sa.findByFilaAndColumnaAndFinca(fila,columna,finca).get();
arbol.setUbicacion(ubicacion);
sa.save(arbol);
return new ResponseEntity<>(arbol, HttpStatus.OK);
}
@GetMapping("/fincas/plano/{idfinca}")
public ResponseEntity<?> planomaster(@PathVariable int idfinca){
	try {
		FincaVO finca= sf.findById(idfinca).get();	
		List<ArbolVO> arboles= sa.findAllByFinca(finca);
		return new ResponseEntity<>(arboles, HttpStatus.OK);
	} catch (NoSuchElementException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	} catch (Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
}


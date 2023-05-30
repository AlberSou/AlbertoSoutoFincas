package com.dawes.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dawes.modelo.FincaVO;
import com.dawes.modelo.TratamientoVO;
import com.dawes.modelo.VariedadVO;
import com.dawes.servicios.ServicioFinca;
import com.dawes.servicios.ServicioTratamiento;
import com.dawes.servicios.ServicioVariedad;


@SpringBootTest
class TestPrueba {
	
	@Autowired
	ServicioVariedad sv;
	@Autowired
	ServicioFinca sf;
	@Autowired
	ServicioTratamiento st;
	
	@Test
	void test01() {
		assertNotNull(sv.save(new VariedadVO("variedad1")));
	}
	@Test
	void test02() {
		//assertNotNull(sf.save(new FincaVO("Finca1","direccion1","referencia1",23f, LocalDate.of(1999, 5,25, 0),5)));
	}
	@Test
	void test03() {
		assertEquals("variedad1",sv.findByNombre("variedad1").get().getNombre());
	}
	@Test
	void test04() {
		assertNotNull(st.save(new TratamientoVO("Tratamiento1",250f,"Tipo1")));
	}
	

}

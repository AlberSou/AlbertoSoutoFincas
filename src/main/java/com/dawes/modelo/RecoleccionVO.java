package com.dawes.modelo;

import java.time.LocalDate;
import java.util.Date;

import org.hibernate.annotations.ManyToAny;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "recolecciones")
public class RecoleccionVO {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idrecoleccion;
private String temporada;
private float kilo;
@DateTimeFormat(pattern = "yyyy-MM-dd")
private Date fecharecoleccion;
@ManyToOne
@JoinColumn(name = "idvariedad")
private VariedadVO variedad;
@ManyToOne
@JoinColumn(name = "idfinca")
private FincaVO finca;


}
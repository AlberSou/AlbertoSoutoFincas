package com.dawes.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "variedades", uniqueConstraints = @UniqueConstraint(columnNames = "nombre"))
public class VariedadVO {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idvariedad;
private String nombre;


		
}

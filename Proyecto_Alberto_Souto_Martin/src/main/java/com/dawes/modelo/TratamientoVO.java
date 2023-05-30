package com.dawes.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tratamientos")
public class TratamientoVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idtratamiento;
	private String denominacion;
	private float dosisrecomendada;
	private String tipo;
	@ManyToOne
	@JoinColumn(name = "idarbol")
	private ArbolVO arbol;
	
}

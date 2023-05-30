package com.dawes.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fotos")
public class FotoVO {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idfoto;
private String url;
private String alias;
@ManyToOne
@JoinColumn(name = "idarbol")
private ArbolVO arbol;


		
}

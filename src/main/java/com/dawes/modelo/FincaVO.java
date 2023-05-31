package com.dawes.modelo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fincas", uniqueConstraints = @UniqueConstraint(columnNames = "denominacion"))
public class FincaVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idfinca;
    private String denominacion;
    private String direccion;
    private String referenciacatastral;
    private double superficie;
    private String localizacion;
    
    
    public FincaVO(String denominacion, String direccion, String referenciacatastral, double superficie,
            String localizacion) {
        super();
        this.denominacion = denominacion;
        this.direccion = direccion;
        this.referenciacatastral = referenciacatastral;
        this.superficie = superficie;
        this.localizacion = localizacion;
    }
}

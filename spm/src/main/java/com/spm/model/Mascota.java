package com.spm.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Mascota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String nombre;
	private Date fechaNac;
	private String raza;
	private float peso;
	private boolean tieneChip;
	private String urlFoto;

	// He forzado que ciertos atributos se guarden siempre en mayúsculas para
	// facilitarme el trabajo y protegerme contra usuarios que buscan por estos
	// atributos en mayúsuculas o minúsculas
	public void setNombre(String nombre) {
		this.nombre = nombre.toUpperCase();
	}

}

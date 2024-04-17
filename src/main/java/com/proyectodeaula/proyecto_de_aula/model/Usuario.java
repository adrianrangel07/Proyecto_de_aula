package com.proyectodeaula.proyecto_de_aula.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario") //crear tabla usuario con los datos de abajo 
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	int id;
	String nombrePer;
	String apellidoPer;
	String email;
	String contraseña;
	String repetirContraseña;

	public Usuario() {
	}

	public Usuario(int id, String nombrePer, String apellidoPer, String email, String contraseña,
			String repetirContraseña) {
		this.id = id;
		this.nombrePer = nombrePer;
		this.apellidoPer = apellidoPer;
		this.email = email;
		this.contraseña = contraseña;
		this.repetirContraseña = repetirContraseña;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombrePer() {
		return nombrePer;
	}

	public void setNombrePer(String nombrePer) {
		this.nombrePer = nombrePer;
	}

	public String getApellidoPer() {
		return apellidoPer;
	}

	public void setApellidoPer(String apellidoPer) {
		this.apellidoPer = apellidoPer;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getRepetirContraseña() {
		return repetirContraseña;
	}

	public void setRepetirContraseña(String repetirContraseña) {
		this.repetirContraseña = repetirContraseña;
	}

	

}

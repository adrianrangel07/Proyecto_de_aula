package com.proyectodeaula.proyecto_de_aula.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Empresa")
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	int id;
	String nombreEmp;
    String direccion;
    String descripcion;
    String email;
    String contraseña;
    String repetirContraseña;
    
    public Empresa () {
    }

	public Empresa(int id, String nombreEmp, String direccion, String descripcion ,String email, String contraseña, String repetirContraseña) {
		this.id = id;
		this.nombreEmp = nombreEmp;
		this.direccion = direccion;
		this.descripcion = descripcion;
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

	public String getNombreEmp() {
		return nombreEmp;
	}

	public void setNombreEmp(String nombreEmp) {
		this.nombreEmp = nombreEmp;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
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

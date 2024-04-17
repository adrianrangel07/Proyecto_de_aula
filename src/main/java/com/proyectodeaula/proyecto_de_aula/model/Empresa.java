package com.proyectodeaula.proyecto_de_aula.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Empresa")
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	int id;
	String nombreEmp;
    String direccion;
    String descripcion;
    String Email;
    int contraseña;
    int repetirContraseña;
    
    public Empresa () {
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
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getContraseña() {
		return contraseña;
	}
	public void setContraseña(int contraseña) {
		this.contraseña = contraseña;
	}
	public int getRepetirContraseña() {
		return repetirContraseña;
	}
	public void setRepetirContraseña(int repetirContraseña) {
		this.repetirContraseña = repetirContraseña;
	}
    
    
}

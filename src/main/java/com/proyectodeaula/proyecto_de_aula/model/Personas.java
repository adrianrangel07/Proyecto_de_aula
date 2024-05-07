package com.proyectodeaula.proyecto_de_aula.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Personas") //crear tabla persona con los datos de abajo 
public class Personas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column(name = "Nombreper", columnDefinition = "VARCHAR(45)", nullable = false)
	String nombrePer;
	@Column(name = "Apellidoper", columnDefinition = "VARCHAR(45)", nullable = false)
	String apellidoPer;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_persona_id", referencedColumnName = "id")
    private Usuario_persona usuario_persona;

	public Personas() {
	}

	public Personas(int id, String nombrePer, String apellidoPer, Usuario_persona usuario_persona) {
		this.id = id;
		this.nombrePer = nombrePer;
		this.apellidoPer = apellidoPer;
		this.usuario_persona = usuario_persona;
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

	public Usuario_persona getUsuario_persona() {
		return usuario_persona;
	}

	public void setUsuario_persona(Usuario_persona usuario_persona) {
		this.usuario_persona = usuario_persona;
	}

	

}

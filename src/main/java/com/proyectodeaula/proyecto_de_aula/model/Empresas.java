package com.proyectodeaula.proyecto_de_aula.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Empresas")
public class Empresas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	int id;
	String nombreEmp;
    String direccion;
    String razon_social;
	int Nit;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_empresa_id", referencedColumnName = "id")
    private Usuario_empresa Usuario_empresa;

    public Empresas () {
    }

	public Empresas(int id, String nombreEmp, String direccion, String razon_social, int nit,
			com.proyectodeaula.proyecto_de_aula.model.Usuario_empresa usuario_empresa) {
		this.id = id;
		this.nombreEmp = nombreEmp;
		this.direccion = direccion;
		this.razon_social = razon_social;
		Nit = nit;
		Usuario_empresa = usuario_empresa;
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

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

	public int getNit() {
		return Nit;
	}

	public void setNit(int nit) {
		Nit = nit;
	}

	public Usuario_empresa getUsuario_empresa() {
		return Usuario_empresa;
	}

	public void setUsuario_empresa(Usuario_empresa usuario_empresa) {
		Usuario_empresa = usuario_empresa;
	}
}


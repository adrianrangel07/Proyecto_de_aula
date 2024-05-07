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
@Table(name = "Usuario_empresa")
public class Usuario_empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    int id;
    @Column(name = "email", columnDefinition = "VARCHAR(45)", nullable = false)
    String email;
    @Column(name = "contraseña", columnDefinition = "VARCHAR(45)", nullable = false)
	String contraseña;
    @Column(name = "repetir_contraseña", columnDefinition = "VARCHAR(45)", nullable = false)
    String repetirContraseña;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "empresas_id", referencedColumnName = "id")
    private Empresas empresa;
    
    public Usuario_empresa() {
    }

    public Usuario_empresa(int id, String email, String contraseña, String repetirContraseña, Empresas empresa) {
        this.id = id;
        this.email = email;
        this.contraseña = contraseña;
        this.repetirContraseña = repetirContraseña;
        this.empresa = empresa;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    
    public Empresas getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresas empresa) {
        this.empresa = empresa;
    }
}

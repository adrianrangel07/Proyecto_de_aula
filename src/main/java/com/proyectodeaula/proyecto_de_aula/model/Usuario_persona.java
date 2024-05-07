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
@Table(name = "Usuario_persona")
public class Usuario_persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    int id;
    @Column(name = "email", columnDefinition = "VARCHAR(45)", nullable = false)
    String email;
    @Column(name = "contraseña", columnDefinition = "VARCHAR(45)", nullable = false)
    String contraseña;
    @Column(name = "repetir_contraseña", columnDefinition = "VARCHAR(45)", nullable = false)
    String repetir_contraseña;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Personas_id", referencedColumnName = "id")
    private Personas Personas;

    public Usuario_persona() {
    }

    public Usuario_persona(int id, String email, String contraseña, String repetir_contraseña, Personas personas) {
        this.id = id;
        this.email = email;
        this.contraseña = contraseña;
        this.repetir_contraseña = repetir_contraseña;
        Personas = personas;
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
        return repetir_contraseña;
    }
    
    public void setRepetirContraseña(String repetirContraseña) {
        this.repetir_contraseña = repetirContraseña;
    }
    
    public Personas getPersonas() {
        return Personas;
    }

    public void setPersonas(Personas personas) {
        Personas = personas;
    }

}

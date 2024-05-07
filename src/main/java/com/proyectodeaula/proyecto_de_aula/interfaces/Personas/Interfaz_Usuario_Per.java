package com.proyectodeaula.proyecto_de_aula.interfaces.Personas;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectodeaula.proyecto_de_aula.model.Usuario_persona;

public interface Interfaz_Usuario_Per extends JpaRepository<Usuario_persona, Integer>{
    Usuario_persona findByEmailAndContraseña(String Email, String Contraseña);
}
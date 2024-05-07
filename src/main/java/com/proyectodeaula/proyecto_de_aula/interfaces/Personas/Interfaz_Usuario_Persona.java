package com.proyectodeaula.proyecto_de_aula.interfaces.Personas;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyectodeaula.proyecto_de_aula.model.Usuario_persona;

@Repository
public interface Interfaz_Usuario_Persona extends CrudRepository <Usuario_persona, Integer>{
}
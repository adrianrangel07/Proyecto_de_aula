package com.proyectodeaula.proyecto_de_aula.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyectodeaula.proyecto_de_aula.model.Usuario;


@Repository
public interface Interfaz_Usuario extends CrudRepository <Usuario, Integer>{
}



package com.proyectodeaula.proyecto_de_aula.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyectodeaula.proyecto_de_aula.model.Empresa;

@Repository
public interface Interfaz_Empresa extends CrudRepository <Empresa, Integer> {  
}

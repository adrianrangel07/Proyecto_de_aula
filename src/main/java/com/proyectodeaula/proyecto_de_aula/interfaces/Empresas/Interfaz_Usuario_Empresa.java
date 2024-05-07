package com.proyectodeaula.proyecto_de_aula.interfaces.Empresas;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyectodeaula.proyecto_de_aula.model.Usuario_empresa;

@Repository
public interface Interfaz_Usuario_Empresa extends CrudRepository <Usuario_empresa, Integer> {  
}
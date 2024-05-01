package com.proyectodeaula.proyecto_de_aula.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectodeaula.proyecto_de_aula.model.Empresa;

public interface  Interfaz_Emp extends JpaRepository<Empresa, Integer>{
    Empresa findByEmailAndContraseña(String Email, String Contraseña);
}

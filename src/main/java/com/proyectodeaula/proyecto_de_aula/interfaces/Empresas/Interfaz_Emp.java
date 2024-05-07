package com.proyectodeaula.proyecto_de_aula.interfaces.Empresas;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectodeaula.proyecto_de_aula.model.Usuario_empresa;

public interface Interfaz_Emp extends JpaRepository<Usuario_empresa, Integer>{
    Usuario_empresa findByEmailAndContraseña(String email, String contraseña);
}

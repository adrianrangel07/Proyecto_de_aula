package com.proyectodeaula.proyecto_de_aula.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proyectodeaula.proyecto_de_aula.model.Usuario;

public interface Interfaz_user extends JpaRepository<Usuario, Integer>{
    Usuario findByEmailAndContraseña(String Email, String Contraseña);
}

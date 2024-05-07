package com.proyectodeaula.proyecto_de_aula.interfaceService;

import java.util.List;
import java.util.Optional;

import com.proyectodeaula.proyecto_de_aula.model.Usuario_persona;

public interface Iusuario_perService {
    public List<Usuario_persona>listar();
    public Optional<Usuario_persona>listarId(int id);
    public int save(Usuario_persona UP);
    public void delete (int Id);
}

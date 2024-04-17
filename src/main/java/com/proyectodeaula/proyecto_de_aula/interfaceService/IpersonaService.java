package com.proyectodeaula.proyecto_de_aula.interfaceService;

import com.proyectodeaula.proyecto_de_aula.model.Usuario;
import java.util.List;
import java.util.Optional;

public interface IpersonaService {
    public List<Usuario>listar();
    public Optional<Usuario>listarId(int id);
    public int save(Usuario U);
    public void delete (int Id);
}

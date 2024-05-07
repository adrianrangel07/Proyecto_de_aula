package com.proyectodeaula.proyecto_de_aula.interfaceService;

import java.util.List;
import java.util.Optional;

import com.proyectodeaula.proyecto_de_aula.model.Usuario_empresa;

public interface Iusuario_empService {
    public List<Usuario_empresa>listar_Usu_Emp();
    public Optional<Usuario_empresa>listarId(int id);
    public int save(Usuario_empresa UE);
    public void delete (int Id);
}

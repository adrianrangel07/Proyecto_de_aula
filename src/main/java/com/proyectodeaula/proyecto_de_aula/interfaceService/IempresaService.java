package com.proyectodeaula.proyecto_de_aula.interfaceService;

import java.util.List;
import java.util.Optional;
import com.proyectodeaula.proyecto_de_aula.model.Empresa;

public interface IempresaService {
    public List<Empresa>listar_Emp();
    public Optional<Empresa>listarId(int id);
    public int save(Empresa E);
    public void delete (int Id);
}

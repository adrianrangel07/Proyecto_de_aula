package com.proyectodeaula.proyecto_de_aula.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyectodeaula.proyecto_de_aula.interfaceService.IempresaService;
import com.proyectodeaula.proyecto_de_aula.interfaces.Empresas.Interfaz_Empresa;
import com.proyectodeaula.proyecto_de_aula.model.Empresas;

@Service
public class EmpresaService implements IempresaService {

    @Autowired
    private Interfaz_Empresa dataEmp;

    @Override
    public List<Empresas> listar_Emp() {
       return (List<Empresas>)dataEmp.findAll();
    }

    @Override
    public Optional<Empresas> listarId(int id) {
        throw new UnsupportedOperationException("Unimplemented method 'listarId'");
    }

    @Override
    public int save(Empresas E) {
        int res= 0;
        Empresas emp = dataEmp.save(E);
        if(!emp.equals(null)){
            res=1;
        }
        return res;
        
    }

    @Override
    public void delete(int Id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}

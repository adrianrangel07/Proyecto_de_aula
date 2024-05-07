package com.proyectodeaula.proyecto_de_aula.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyectodeaula.proyecto_de_aula.interfaceService.IpersonaService;
import com.proyectodeaula.proyecto_de_aula.interfaces.Personas.Interfaz_Persona;
import com.proyectodeaula.proyecto_de_aula.model.Personas;
 
@Service
public class PersonaService implements IpersonaService{

    @Autowired
    private Interfaz_Persona data;

    @Override
    public List<Personas> listar() {
       return (List<Personas>)data.findAll();
    }

    @Override
    public Optional<Personas> listarId(int id) {
        throw new UnsupportedOperationException("Unimplemented method 'listarId'");
    }

    @Override
    public int save(Personas U) {
        int res= 0;
        Personas Usu = data.save(U);
        if(!Usu.equals(null)){
            res=1;
        }
        return res;
        
    }

    @Override
    public void delete(int Id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}

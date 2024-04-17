package com.proyectodeaula.proyecto_de_aula.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyectodeaula.proyecto_de_aula.interfaceService.IpersonaService;
import com.proyectodeaula.proyecto_de_aula.interfaces.Interfaz_Usuario;
import com.proyectodeaula.proyecto_de_aula.model.Usuario;

@Service
public class UsuarioService implements IpersonaService{

    @Autowired
    private Interfaz_Usuario data;

    @Override
    public List<Usuario> listar() {
       return (List<Usuario>)data.findAll();
    }

    @Override
    public Optional<Usuario> listarId(int id) {
        throw new UnsupportedOperationException("Unimplemented method 'listarId'");
    }

    @Override
    public int save(Usuario U) {
        int res= 0;
        Usuario Usu = data.save(U);
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

package com.proyectodeaula.proyecto_de_aula.model;

public class PersonaForm {

    private Personas personas;
    private Usuario_persona usuario_persona;
    
    public PersonaForm() {
    }

    public PersonaForm(Personas personas, Usuario_persona usuario_persona) {
        this.personas = personas;
        this.usuario_persona = usuario_persona;
    }

    public Personas getPersonas() {
        return personas;
    }
    public void setPersonas(Personas personas) {
        this.personas = personas;
    }
    public Usuario_persona getUsuario_persona() {
        return usuario_persona;
    }
    public void setUsuario_persona(Usuario_persona usuario_persona) {
        this.usuario_persona = usuario_persona;
    }

}

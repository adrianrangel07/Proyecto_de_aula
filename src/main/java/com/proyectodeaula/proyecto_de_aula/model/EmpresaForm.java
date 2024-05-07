package com.proyectodeaula.proyecto_de_aula.model;

public class EmpresaForm {

    private Empresas empresas;
    private Usuario_empresa usuario_empresa;

    public EmpresaForm() {
    }

    public EmpresaForm(Empresas empresas, Usuario_empresa usuario_empresa) {
        this.empresas = empresas;
        this.usuario_empresa = usuario_empresa;
    }
    
    public Empresas getEmpresas() {
        return empresas;
    }
    public void setEmpresas(Empresas empresas) {
        this.empresas = empresas;
    }
    public Usuario_empresa getUsuario_empresa() {
        return usuario_empresa;
    }
    public void setUsuario_empresa(Usuario_empresa usuario_empresa) {
        this.usuario_empresa = usuario_empresa;
    }
}

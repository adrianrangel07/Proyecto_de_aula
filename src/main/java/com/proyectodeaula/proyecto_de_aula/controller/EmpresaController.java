package com.proyectodeaula.proyecto_de_aula.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyectodeaula.proyecto_de_aula.interfaces.Empresas.Interfaz_Empresa;
import com.proyectodeaula.proyecto_de_aula.interfaces.Empresas.Interfaz_Usuario_Emp;
import com.proyectodeaula.proyecto_de_aula.model.EmpresaForm;
import com.proyectodeaula.proyecto_de_aula.model.Empresas;
import com.proyectodeaula.proyecto_de_aula.model.Personas;
import com.proyectodeaula.proyecto_de_aula.model.Usuario_empresa;
import com.proyectodeaula.proyecto_de_aula.model.Usuario_persona;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping
public class EmpresaController {

	@Autowired
	private Interfaz_Usuario_Emp u_emp;

	@Autowired
	private Interfaz_Empresa emp;

	@GetMapping("/registrar_Empresa")
	public String agregar(Model model) {
        EmpresaForm empresaForm = new EmpresaForm();
        empresaForm.setEmpresas(new Empresas());
        empresaForm.setUsuario_empresa(new Usuario_empresa());
        model.addAttribute("empresaForm", empresaForm);
        return "html/Registrar_empresa";
    }

	@PostMapping("/login_empresa")
	public String save(@ModelAttribute("empresaForm") EmpresaForm empresaForm, Model model) {
        // Obtener los datos de empresa y usuario_empresa
        Empresas empresa = empresaForm.getEmpresas();
        Usuario_empresa usuario = empresaForm.getUsuario_empresa();

        // Guardar la empresa y obtener su ID
        empresa = emp.save(empresa);

        // Establecer la relación en usuario_empresa
        usuario.setEmpresa(empresa);

        // Guardar el usuario_empresa
        usuario = u_emp.save(usuario);

        // Redireccionar a alguna página de éxito o mostrar un mensaje
        return "redirect:/login_empresa";
    }

	@GetMapping("/login_empresa")
	public String login_empresa() {
        return "html/Login_empresa"; // Devuelve la vista de inicio
	}

	// inicio de sesion, validacion de datos y redireccionamiendo de pagina
	@PostMapping("/inicio_empresa")
	public String iniciarSesionemp(Model model, @RequestParam String email, @RequestParam String contraseña,HttpSession session) {
        // Buscar al usuario en la base de datos por su email y contraseña
        Usuario_empresa usu_empresa = u_emp.findByEmailAndContraseña(email, contraseña);
        if (usu_empresa != null) {
            // Aquí obtienes la empresa asociada al usuario
            Empresas empresa = usu_empresa.getEmpresa();
            if (empresa != null) {
                session.setAttribute("loggedInEmp", usu_empresa); // Almacenar el usuario en la sesión
                model.addAttribute("nombreEmpresa", empresa.getNombreEmp());
                // Si el usuario existe, puedes redirigir a la página InicioEmp.html
                return "html/InicioEmp";
            } else {
                // Si la empresa asociada al usuario es nula, puedes agregar un mensaje de error
                model.addAttribute("error", "La empresa asociada al usuario no fue encontrada");
                return "html/contraseña_incorrectaemp";
            }
        } else {
            // Si el usuario no existe o las credenciales son incorrectas, puedes agregar un
            // mensaje de error y volver al formulario de inicio de sesión
            model.addAttribute("error", "Credenciales incorrectas");
            return "html/contraseña_incorrectaemp";
        }
    }

	@GetMapping("/inicio_empresa")
	public String inicio() {
		return "html/InicioEmp";
	}

	@GetMapping("/contraseña_incorrectaemp")
	public String contraseña_incorrecta() {
		return "html/contraseña_incorrectaemp";
	}

    @GetMapping("/oferta")
	public String oferta() {
		return "html/Oferta";
	}

    @GetMapping("/Contraseña-olvidada-empresa")
    public String olvidar_emp(){
        return "html/contraseña_olvidada_emp";
    }

    @GetMapping("/Perfil-Empresa")
    public String perfil_emp(Model model, HttpSession session) {
        Usuario_empresa usu_empresa = (Usuario_empresa) session.getAttribute("loggedInEmp");
        if (usu_empresa != null) {
            Empresas empresa = usu_empresa.getEmpresa();
            model.addAttribute("nombreemp", empresa.getNombreEmp());
            model.addAttribute("direccion", empresa.getDireccion());
            model.addAttribute("emailemp", usu_empresa.getEmail());
        }
        return "html/perfilemp";
    }
}
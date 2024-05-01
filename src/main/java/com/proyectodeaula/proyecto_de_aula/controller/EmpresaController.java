package com.proyectodeaula.proyecto_de_aula.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import com.proyectodeaula.proyecto_de_aula.interfaceService.IempresaService;
import com.proyectodeaula.proyecto_de_aula.interfaces.Interfaz_Emp;
import com.proyectodeaula.proyecto_de_aula.model.Empresa;

@Controller
@RequestMapping
public class EmpresaController {
    
    @Autowired
    private  IempresaService Empservice;
    
	@Autowired
	private Interfaz_Emp emp;

	@GetMapping("/empresa")
	public String listar(Model model) {
		List<Empresa> Empresas = Empservice.listar_Emp();
		model.addAttribute("Empresas", Empresas);
		return "html/Inicio";
	}

    @GetMapping("/registrar_empresa")
	public String agregar(Model model) {
		model.addAttribute("Empresa", new Empresa());
		return "html/Registrar_empresa";
	}

    @PostMapping("/login_empresa")
	public String save(@Validated Empresa E, Model model) {
		Empservice.save(E);
		return "html/login_empresa";
	}

	@GetMapping("/login_empresa")
	private String iniciar_Sesionemp() { // Devuelve la vista iniciar sesion
		return "html/login_empresa";
	}

    @PostMapping("/InicioEmp")
	public String iniciarSesionemp(Model model, @RequestParam String email, @RequestParam String contraseña) {
		// Buscar al usuario en la base de datos por su email y contraseña
		Empresa empresa = emp.findByEmailAndContraseña(email, contraseña);
		if (empresa != null) {
			model.addAttribute("nombreEmpresa", empresa.getNombreEmp());
			// Si el usuario existe, puedes redirigir a la página Inicio_login.html
			return "html/InicioEmp";
		} else {
			// Si el usuario no existe o las credenciales son incorrectas, puedes agregar un
			// mensaje de error y volver al formulario de inicio de sesión
			model.addAttribute("error", "Credenciales incorrectas");
			return "html/contraseña_incorrectaemp";
		}
	}

    @GetMapping("/inicio_Empresa")
	public String inicio_emp() {
		return "html/InicioEmp";
	}
}

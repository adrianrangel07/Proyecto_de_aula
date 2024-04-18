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

import com.proyectodeaula.proyecto_de_aula.interfaceService.IpersonaService;
import com.proyectodeaula.proyecto_de_aula.interfaces.Interfaz_user;
import com.proyectodeaula.proyecto_de_aula.model.Usuario;

@Controller
@RequestMapping
public class UsuarioController {

	@Autowired
	private IpersonaService service;

	@Autowired
	private Interfaz_user user;

	@GetMapping("/Home")
	public String listar(Model model) {
		List<Usuario> Usuarios = service.listar();
		model.addAttribute("Usuarios", Usuarios);
		return "html/Inicio";
	}

	@GetMapping("/registrar_usuario")
	public String agregar(Model model) {
		model.addAttribute("Usuario", new Usuario());
		return "html/Registrar_persona";
	}

	@PostMapping("/login_persona")
	public String save(@Validated Usuario U, Model model) {
		service.save(U);
		return "html/login_persona";
	}
	//llamar a login persona, para que inicie  sesion 
	@GetMapping("/login_persona")
	private String iniciar_sesion() { // Devuelve la vista iniciar sesion
		return "html/login_persona";
	}

	// inicio de sesion, validacion de datos y redireccionamiendo de pagina 
	@PostMapping("/login_inicio")
	public String iniciarSesion(Model model, @RequestParam String email, @RequestParam String contraseña) {
		// Buscar al usuario en la base de datos por su email y contraseña
		Usuario usuario = user.findByEmailAndContraseña(email, contraseña);
		if (usuario != null) {
			// Si el usuario existe, puedes redirigir a la página Inicio_login.html
			return "html/Inicio_login";
		} else {
			// Si el usuario no existe o las credenciales son incorrectas, puedes agregar un
			// mensaje de error y volver al formulario de inicio de sesión
			model.addAttribute("error", "Credenciales incorrectas");
			return "html/login_persona";
		}
	}

	//llamar a inicio login (inicio de cuando inician sesion usuarios)
	

	@GetMapping("/Inicio_Sesion_Empresa")
	public String login_empresa() {
		return "html/Login_empresa"; // Devuelve la vista de inicio
	}

	@GetMapping("/registro_empresa")
	public String registro_emp() {
		return "html/Registrar_empresa";
	}

	@GetMapping("/Nosotros")
	public String Nosotros() {
		return "html/Nosotros";
	}
}

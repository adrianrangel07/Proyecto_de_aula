package com.proyectodeaula.proyecto_de_aula.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.proyectodeaula.proyecto_de_aula.interfaces.Personas.Interfaz_Persona;
import com.proyectodeaula.proyecto_de_aula.interfaces.Personas.Interfaz_Usuario_Per;
import com.proyectodeaula.proyecto_de_aula.model.PersonaForm;
import com.proyectodeaula.proyecto_de_aula.model.Personas;
import com.proyectodeaula.proyecto_de_aula.model.Usuario_persona;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping
public class PersonaController {

    @Autowired
    private Interfaz_Usuario_Per user;

    @Autowired
    private Interfaz_Persona per;

    @GetMapping("/registrar_persona")
    public String agregar(Model model) {
        PersonaForm personaForm = new PersonaForm();
        personaForm.setPersonas(new Personas());
        personaForm.setUsuario_persona(new Usuario_persona());
        model.addAttribute("personaForm", personaForm);
        return "Html/Registrar_persona";
    }

    @PostMapping("/login_persona")
    public String save(@ModelAttribute("personaForm") PersonaForm personaForm, Model model) {
        // Obtener los datos de persona y usuario_persona
        Personas persona = personaForm.getPersonas();
        Usuario_persona usuario = personaForm.getUsuario_persona();

        // Guardar la persona y obtener su ID
        persona = per.save(persona);

        // Establecer la relación en usuario_persona
        usuario.setPersonas(persona);

        // Guardar el usuario_persona
        usuario = user.save(usuario);

        // Redireccionar a la página de inicio de sesión
        return "redirect:/login_persona";
    }

    @GetMapping("/login_persona")
    public String iniciar_sesion() {
        return "html/login_persona";
    }

    @PostMapping("/login_inicio")
    public String iniciarSesion(Model model, @RequestParam String email, @RequestParam String contraseña,
            HttpSession session) {
        Usuario_persona usuario = user.findByEmailAndContraseña(email, contraseña);
        if (usuario != null) {
            Personas persona = usuario.getPersonas();
            if (persona != null) {
                session.setAttribute("loggedInUser", usuario); // Almacenar el usuario en la sesión
                model.addAttribute("nombreUsuario", persona.getNombrePer());
                return "redirect:/login_inicio";
            } else {
                model.addAttribute("error", "La persona asociada al usuario no fue encontrada");
                return "html/contraseña_incorrectauser";
            }
        } else {
            model.addAttribute("error", "Credenciales incorrectas");
            return "html/contraseña_incorrectauser";
        }
    }

    @GetMapping("/Nosotros")
    public String Nosotros() {
        return "html/Nosotros";
    }

    @GetMapping("/contraseña_incorrectauser")
    public String contraseña_incorrecta() {
        return "html/contraseña_incorrectauser";
    }

    @GetMapping("/Estadisticas")
    public String estadistica() {
        return "html/Estadisticas";
    }

    @GetMapping("/Contraseña-olvidada")
    public String olvidar() {
        return "html/contraseña_olvidada_per";
    }

    @GetMapping("/perfil")
    public String Myperfil(Model model, HttpSession session) {
        Usuario_persona usuario = (Usuario_persona) session.getAttribute("loggedInUser");
        if (usuario != null) {
            Personas persona = usuario.getPersonas();
            model.addAttribute("nombre", persona.getNombrePer());
            model.addAttribute("apellido", persona.getApellidoPer());
            model.addAttribute("email", usuario.getEmail());
        }
        return "html/Mi_perfil";
    }

}
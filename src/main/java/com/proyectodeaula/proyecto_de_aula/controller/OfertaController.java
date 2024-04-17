package com.proyectodeaula.proyecto_de_aula.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyectodeaula.proyecto_de_aula.interfaceService.IofertaService;
import com.proyectodeaula.proyecto_de_aula.model.Ofertas;

import org.springframework.ui.Model;

@Controller
@RequestMapping
public class OfertaController {

    @Autowired
    private IofertaService offerService;

    @GetMapping("/")
	public String listar_ofertas(Model model){
		List <Ofertas> Ofertas=offerService.listar_ofertas();
		model.addAttribute("Ofertas", Ofertas);
		return "html/Inicio";
	}
}




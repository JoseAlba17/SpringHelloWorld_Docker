package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/helloworld") // nombre del recurso
public class HelloWorldController {
	
	@GetMapping("/saludo")
	public String getViewHelloWorld(
			@RequestParam("nombre") String nombre,
			@RequestParam("apellidos") String apellidos,
			@RequestParam("edad") int edad, Model model) {
		// Comunicar datos/modelo a la vista con el objeto Model
		System.out.println("Nombre: " + nombre);
		// Poner datos para la vista
		model.addAttribute("nombre", nombre);
		model.addAttribute("apellidos", apellidos);
		model.addAttribute("edad", edad);
		return "saludo"; // nombre archivo
	}
}
package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/todolist")
public class TodoListController {
	
	@GetMapping
	public String getTodoList(Model model) {
		
		// Datos que van a la vista
		List<String> list = new ArrayList<>();
		list.add("Empezar curso de JavaScript");
		list.add("Realizar curso de creacion de SPA, AJAX, JSON, RESTAPI");
		list.add("Hacer ejercicio tres veces a la semana");
		
		model.addAttribute("todolist", list);
		return "todolist";
	}
	
	@GetMapping("/newtask")
	public String newTask() {
		return "formTask";
	}
	
	@PostMapping
	public String createTask(@RequestParam("content") String content, Model model) {
		model.addAttribute("task", content);
		return "result";
	}
}

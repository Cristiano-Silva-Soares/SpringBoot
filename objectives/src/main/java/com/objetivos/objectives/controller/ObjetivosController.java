package com.objetivos.objectives.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/objectives")
public class ObjetivosController 
{
	@GetMapping()
	public String objetivo1()
	{
		return "Melhorar ainda mais meus conhecimentos técnicos.";
	}
	@GetMapping("/route2")
	public String objetivo2()
	{
		return "Entregar todas as minhas atividades dentro do tempo limite";
	}
	@GetMapping("/route3")
	public String objetivo3() 
	{
		return "Melhorar ainda mais meu perfil do LinkedIn.";
	}
}

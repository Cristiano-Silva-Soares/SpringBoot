package com.habilidades.habilities.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/habilities")
public class HabilidadesController 
{
	@GetMapping
	public String bsm()
	{
		return "Persistência.";
	}
	@GetMapping("/route2")
	public String hs()
	{
		return "Atenção aos detalhes.";
	}
	@GetMapping("/route3")
	public String bsm2()
	{
		return "Mentalidade de crescimento.";
	}
}

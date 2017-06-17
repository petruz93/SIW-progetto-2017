package it.uniroma3.galleria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.galleria.model.Autore;
import it.uniroma3.galleria.service.AutoreService;

@Controller
public class AutoreController {
	
	@Autowired
	private AutoreService autoreService;
	
	@GetMapping("/autore")
	public String showForm(Autore autore) {
		return "inserimento";
	}
	
	@PostMapping("/autore")
	public String checkAutoreInfo(@Valid @ModelAttribute Autore autore,
									BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			return "inserimento";
		} else {
			this.autoreService.add(autore);
			Iterable<Autore> autori = this.autoreService.findAll();
			model.addAttribute("autori", autori);
			return "autori";
		}
	}
	
	@GetMapping("/listAutori")
	public String mostraAutori(Model model) {
		Iterable<Autore> autori = this.autoreService.findAll();
		model.addAttribute("autori", autori);
		return "autori";
	}

}

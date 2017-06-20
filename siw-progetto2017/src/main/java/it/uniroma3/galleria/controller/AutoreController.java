package it.uniroma3.galleria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.galleria.model.Autore;
import it.uniroma3.galleria.service.AutoreService;

@Controller
public class AutoreController {
	
	@Autowired
	private AutoreService autoreService;
	
	@GetMapping("/admin/addAutore")
	public String showForm(Autore autore, Model model) {
		model.addAttribute("formAutore", true);
		return "inserimento";
	}
	
	@PostMapping("/admin/addAutore")
	public String checkAutoreInfo(@Valid @ModelAttribute Autore autore,
									BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			return showForm(autore, model);
		}
		// [TODO] inserimento duplicati
		this.autoreService.add(autore);
		return "redirect:/listAutori";
	}
	
	@GetMapping("/listAutori")
	public String showAllAutori(Model model) {
		Iterable<Autore> autori = this.autoreService.findAll();
		model.addAttribute("autori", autori);
		return "autori";
	}
	
	@GetMapping("/showAutore")
	public String infoAutore(@RequestParam Long id, Model model) {
		Autore autore = this.autoreService.findById(id);
		model.addAttribute("autore", autore);
		return "infoAutore";
	}
	
	@PostMapping("/admin/removeAutore")
	public String removeAutore(@RequestParam Long id) {
		this.autoreService.removeById(id);
		return "redirect:/listAutori";
	}

}

package it.uniroma3.galleria.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.uniroma3.galleria.model.Autore;
import it.uniroma3.galleria.service.AutoreService;

@Controller
public class AutoreController {
	
	@Autowired
	private AutoreService autoreService;
	
	@GetMapping("/addAutore")
	public String showForm(Model model) {
		model.addAttribute("formAutore", true);
		return "inserimento";
	}
	
	@PostMapping("/addAutore")
	public String checkAutoreInfo(@Valid @ModelAttribute Autore autore,
									BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors())
			return "inserimento";
		else {
			this.autoreService.add(autore);
			Iterable<Autore> autori = this.autoreService.findAll();
			model.addAttribute("autori", autori);
			return showAllAutori(model);
		}
	}
	
	@GetMapping("/listAutori")
	public String showAllAutori(Model model) {
		Iterable<Autore> autori = this.autoreService.findAll();
		model.addAttribute("autori", autori);
		return "autori";
	}
	
	@GetMapping("/showAutore?id={id}")
	public String infoAutore(@PathVariable Long id, Model model) {
		Autore autore = this.autoreService.findById(id);
		model.addAttribute("autore", autore);
		return "infoAutore";
	}
	
	@PostMapping("/removeAutore")
	@RequestMapping(params={"comando"})
	public String removeAutore(Model model, HttpServletRequest request) {
		Long id = Long.valueOf(request.getParameter("id"));
		this.autoreService.removeById(id);
		return showAllAutori(model);
	}

}

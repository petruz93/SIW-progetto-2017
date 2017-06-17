package it.uniroma3.galleria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.galleria.model.Opera;
import it.uniroma3.galleria.service.OperaService;

@Controller
public class OperaController {
	
	@Autowired
	private OperaService operaService;
	
	@GetMapping("/addOpera")
	public String showForm(Model model) {
		model.addAttribute("formOpera", true);
		return "inserimento";
	}
	
	@PostMapping("/addOpera")
	public String checkOperaInfo(@Valid @ModelAttribute Opera opera,
									BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors())
			return "inserimento";
		else {
			this.operaService.add(opera);
			Iterable<Opera> opere = this.operaService.findAll();
			model.addAttribute("opere", opere);
			return "opere";
		}
	}
	
	@GetMapping("/listOpere")
	public String showAllOpere(Model model) {
		Iterable<Opera> opere = this.operaService.findAll();
		model.addAttribute("opere", opere);
		return "opere";
	}

}

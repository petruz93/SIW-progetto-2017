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
import it.uniroma3.galleria.model.Opera;
import it.uniroma3.galleria.service.AutoreService;
import it.uniroma3.galleria.service.OperaService;

@Controller
public class OperaController {
	
	@Autowired
	private OperaService operaService;
	@Autowired
	private AutoreService autoreService;
	
	@GetMapping("/admin/addOpera")
	public String showForm(Opera opera, Model model) {
		model.addAttribute("formOpera", true);
		Iterable<Autore> autori = this.autoreService.findAll();
		model.addAttribute("autori", autori);
		return "inserimento";
	}
	
	@PostMapping("/admin/addOpera")
	public String checkOperaInfo(@Valid @ModelAttribute Opera opera,
									BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			return showForm(opera, model);
		}
		// [TODO] inserimento duplicati
		this.operaService.add(opera);
		return "redirect:/listOpere";
	}
	
	@GetMapping("/listOpere")
	public String showAllOpere(Model model) {
		Iterable<Opera> opere = this.operaService.findAll();
		model.addAttribute("opere", opere);
		return "opere";
	}
	
	@GetMapping("/showOpera")
	public String infoOpera(@RequestParam Long id, Model model) {
		Opera opera = this.operaService.findById(id);
		model.addAttribute("opera", opera);
		return "infoOpera";
	}
	
	@PostMapping("/admin/removeOpera")
	public String removeOpera(@RequestParam Long id) {
		this.operaService.removeById(id);
		return "redirect:/listOpere";
	}

}

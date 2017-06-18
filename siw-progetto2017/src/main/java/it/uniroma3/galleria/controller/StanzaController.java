package it.uniroma3.galleria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.galleria.model.Stanza;
import it.uniroma3.galleria.service.OperaService;
import it.uniroma3.galleria.service.StanzaService;

@Controller
public class StanzaController {
	
	@Autowired
	private StanzaService stanzaService;
	
	@Autowired
	private OperaService operaService;
	
	@GetMapping("/addStanza")
	public String showForm(Stanza stanza, Model model) {
		model.addAttribute("formStanza", true);
		model.addAttribute("opere", this.operaService.findAll());
		return "inserimento";
	}
	
	@PostMapping("/addStanza")
	public String checkStanzaInfo(@Valid @ModelAttribute Stanza stanza,
									BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			return showForm(stanza, model);
		}
		// [TODO] inserimento duplicati
		this.stanzaService.add(stanza);
		return "redirect:/listStanze";
	}
	
	@GetMapping("/listStanze")
	public String showAllStanze(Model model) {
		Iterable<Stanza> stanze = this.stanzaService.findAll();
		model.addAttribute("stanze", stanze);
		return "stanze";
	}
	
	@GetMapping("/showStanza/{id}")
	public String infoStanza(@PathVariable Long id, Model model) {
		Stanza stanza = this.stanzaService.findById(id);
		model.addAttribute("stanza", stanza);
		return "infoAutore";
	}
	
	@PostMapping("/removeStanza")
	public String removeStanza(@RequestParam Long id) {
		this.stanzaService.removeById(id);
		return "redirect:/listStanze";
	}
	
	@PostMapping("/updateStanza")
	public String moveOpera(@RequestParam Long opera_id, @RequestParam Long stanza_src,
								@RequestParam Long stanza_dest) {
		// [TODO]
		return null;
	}

}

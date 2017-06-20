package it.uniroma3.galleria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.uniroma3.galleria.service.StanzaService;

@Controller
public class MainController {
	
	@Autowired
	private StanzaService stanzaService;
	
	@RequestMapping(value={"/", "/index", "/admin"})
	public String home(Model model) {
		model.addAttribute("stanze", this.stanzaService.findAll());
		return "index";
	}
	
	@RequestMapping("/contatti")
	public String contatti() {
		return "contatti";
	}
	
	@RequestMapping("/admin/amministrazione")
	public String amministrazione() {
		return "amministrazione";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "/index";
	}
	
	@RequestMapping("/login-error.html")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		return home(model);
	}

}

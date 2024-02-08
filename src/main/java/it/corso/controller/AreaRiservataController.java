package it.corso.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Amministrazione;
import it.corso.model.Contatti;
import it.corso.model.Staff;
import it.corso.service.ContattiService;
import jakarta.servlet.http.HttpSession;

// localhost8080:/areariservata
@Controller
@RequestMapping("/areariservata")
public class AreaRiservataController 
{
	@Autowired
	private ContattiService contattiService;
	
	@GetMapping
	public String getPage(
			HttpSession session,
			Model model) 
	{
		if(session.getAttribute("amministratore") == null)
			return "redirect:/login";
		
		Amministrazione amministrazione = (Amministrazione) session.getAttribute("amministratore");
		model.addAttribute("amministratore", amministrazione);
		
		List<Contatti> contatti = contattiService.getAllContatti();
		model.addAttribute("contatti", contatti);
		
		return "/areariservata";	
	}
	
	@GetMapping("/cancellamessaggio")
	public String gestioneCancellazione(@RequestParam("id") int id){
		contattiService.cancellaContatti(contattiService.getContattiById(id));
		return "redirect:/areariservata";
	}
}

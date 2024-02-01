package it.corso.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import it.corso.model.Amministrazione;
import jakarta.servlet.http.HttpSession;

// localhost8080:/areariservata
@Controller
@RequestMapping("/areariservata")
public class AreaRiservataController 
{
	@GetMapping
	public String getPage(
			HttpSession session,
			Model model) 
	{
		if(session.getAttribute("amministratore") == null)
			return "redirect:/login";
		
		Amministrazione amministrazione = (Amministrazione) session.getAttribute("amministratore");
		model.addAttribute("amministratore", amministrazione);
		return "/areariservata";	
	}
}

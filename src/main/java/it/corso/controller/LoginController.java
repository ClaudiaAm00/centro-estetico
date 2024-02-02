package it.corso.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import it.corso.service.AmministrazioneService;
import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private AmministrazioneService amministrazioneService;
	
	@GetMapping
	public String getPage(HttpSession session) {
		if(session.getAttribute("amministratore") != null)
			// se validato va alla pagina riservata
			return "redirect:/areariservata";
		// ritorna pagina login (possibilmente con messaggio di inserimento errato)
		return "login";
	}
	
	@PostMapping("/verifica")
	public String formManager(
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			HttpSession session) 
	{
		if (!amministrazioneService.controlloLogin(username, password, session))
			return "redirect:/login";
		return "redirect:/areariservata";
	}

}

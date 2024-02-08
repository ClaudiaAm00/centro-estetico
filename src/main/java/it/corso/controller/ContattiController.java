package it.corso.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import it.corso.model.Contatti;
import it.corso.service.ContattiService;


@Controller
@RequestMapping("/contatti")
public class ContattiController {
	@Autowired
	private ContattiService contattiService;
	
	private Contatti contatto;
	
	@GetMapping
	public String getPage() {
		return "contatti";
	}
	
	@PostMapping("/aggiungicontatto")
	public String formManager(
			@RequestParam(name = "nome") String nome,
			@RequestParam(name = "cognome") String cognome,
			@RequestParam(name = "email") String email,
			@RequestParam(name = "telefono", required = false) String telefono, 
			@RequestParam(name = "testo") String testo)
	{
		
		contatto = new Contatti();
		contatto.setNome(nome);
		contatto.setCognome(cognome);
		contatto.setEmail(email);
		contatto.setTelefono(telefono);
		contatto.setTesto(testo);
		
		contattiService.registraContatti(contatto);
		
		return "redirect:/contatti";
	}

}


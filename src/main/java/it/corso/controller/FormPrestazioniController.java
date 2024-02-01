package it.corso.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import it.corso.model.Prestazione;
import it.corso.model.Staff;
import it.corso.service.PrestazioneService;


//localhost:8080/formprestazioni
@Controller
@RequestMapping("/formprestazioni")
public class FormPrestazioniController 
{
	@Autowired
	private PrestazioneService prestazioneService;
	
	@GetMapping
	public String getPage()
	{
		return "formprestazione";
	}
	
	@PostMapping("/aggiungiprestazione")
	public String formManager(
			@RequestParam("tipologia") String tipologia,
			@RequestParam("descrizione") String descrizione,
			@RequestParam("prezzo") double prezzo,
			@RequestParam("staff") Staff staff)
	{
		Prestazione prestazione = new Prestazione();
		prestazione.setTipologia(tipologia);
		prestazione.setDescrizione(descrizione);
		prestazione.setPrezzo(prezzo);
		prestazione.setStaff(staff);
		
		prestazioneService.registraPrestazione(prestazione);
		return "redirect:/";  
	} 
}

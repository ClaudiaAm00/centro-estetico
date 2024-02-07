package it.corso.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import it.corso.model.Prestazione;
import it.corso.model.Staff;
import it.corso.service.PrestazioneService;
import jakarta.servlet.http.HttpSession;


//localhost:8080/formprestazioni
@Controller
@RequestMapping("/formprestazioni")
public class FormPrestazioniController 
{
	@Autowired
	private PrestazioneService prestazioneService;
	
	private Prestazione prestazione;
	
	@GetMapping
	public String getPage(HttpSession session, 
			Model model,
			@RequestParam( name = "id", required = false) Integer idPrestazione)
	{
		if(session.getAttribute("amministratore") == null)
			return "redirect:/login";
		
		prestazione = idPrestazione == null ? new Prestazione(): prestazioneService.getPrestazioneById(idPrestazione);
		
		model.addAttribute("prestazione", prestazione);
		
		return "formprestazioni";
	}
	
	
	@PostMapping("/aggiungiprestazione")
	public String formManager(
			@RequestParam(name = "id") Integer idPrestazione,
			@RequestParam(name = "tipologia") String tipologia,
			@RequestParam(name = "descrizione") String descrizione,
			@RequestParam(name = "prezzo") double prezzo,
			@RequestParam(name = "categoria") String categoria,
			@RequestParam(name = "foto", required = false) MultipartFile foto,
			@RequestParam(name = "staff", required = false) Staff staff)
	{
		Prestazione prestazione = new Prestazione();
		prestazione.setId(idPrestazione);
		prestazione.setTipologia(tipologia);
		prestazione.setDescrizione(descrizione);
		prestazione.setPrezzo(prezzo);
		prestazione.setCategoria(categoria);
		prestazione.setStaff(staff);
		
		if (idPrestazione != 0) {
			prestazioneService.aggiornaPrestazione(prestazione, foto, idPrestazione);
		} else {
			prestazioneService.registraPrestazione(prestazione, foto);
		}
		
		return "redirect:/gestioneprestazioni";  
	} 
}






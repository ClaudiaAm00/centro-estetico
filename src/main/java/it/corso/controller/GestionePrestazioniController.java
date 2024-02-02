package it.corso.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import it.corso.model.Prestazione;
import it.corso.service.PrestazioneService;
import jakarta.servlet.http.HttpSession;


//localhost:8080/gestioneprestazioni

@Controller
@RequestMapping("/gestioneprestazioni")
public class GestionePrestazioniController {
	
	@Autowired
	private PrestazioneService prestazioneService;
	
	@GetMapping
	public String getPage(Model model, HttpSession session){
		// se non amministratore, ritorna all'home page
		if(session.getAttribute("amministratore") == null)
			return "redirect:/";
		
		// se amministratore visualizza la pagina
		List<Prestazione> prestazione = prestazioneService.getPrestazioni();
		model.addAttribute("prestazione", prestazione);

		return "gestioneprestazioni";
	}
	
	@GetMapping("/cancellaprestazione")
	public String gestioneCancellazione(@RequestParam("id") int id){
		prestazioneService.cancellaPrestazione(prestazioneService.getPrestazioneById(id));
		return "redirect:/gestioneprestazioni";
	}
	}


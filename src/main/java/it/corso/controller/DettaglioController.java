package it.corso.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import it.corso.service.PrestazioneService;


@Controller
@RequestMapping("/dettaglio")
public class DettaglioController {
	@Autowired
	private PrestazioneService prestazioneService;
	
	@GetMapping
	public String getPage(Model model,
			@RequestParam("id") int id) {
		model.addAttribute("prestazione", prestazioneService.getPrestazioneById(id));
		return "dettaglio";
	}

}

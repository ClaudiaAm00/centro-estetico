package it.corso.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;




//localhost:8080
@Controller
@RequestMapping("/")
public class IndexController {

	
	@GetMapping
	public String getPage(Model model)
	{
		return "index";
	}
	
	
	}
	

//@Valid valida in base ai criteri stabiliti nella classe Utente.java
//BindingResult è un registro dove viene tenuta traccia degli eventuali errori commessi in fase di compilazione (quindi di validazione) dei dati --> tiene traccia degli errori
//se vi sono errori ritorniamo la risorsa grafica index invece che redirect, così da non perdere i dati inseriti nel form (non stiamo reinviando la pagina) e gli errori saranno visibili su HTML (sarà ritornato il message)
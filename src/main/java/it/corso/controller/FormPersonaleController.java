package it.corso.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import it.corso.model.Staff;
import it.corso.service.StaffService;

//localhost:8080/formpersonale
@Controller
@RequestMapping("/formpersonale")
public class FormPersonaleController 
{
	@Autowired
	private StaffService staffService;
	
	@GetMapping
	public String getPage()
	{
		return "formpersonale";
	}
	
	@PostMapping("/aggiungipersona")
	public String formManager(
			@RequestParam("nome") String nome,
			@RequestParam("cognome") String cognome,
			@RequestParam("ruolo") String ruolo,
			@RequestParam(name = "foto", required = false) MultipartFile foto,
			@RequestParam("dataAssunzione") LocalDate dataAssunzione,
			@RequestParam("contratto") String contratto,
			@RequestParam("email") String email,
			@RequestParam("telefono") String telefono) 
	{
		Staff staff = new Staff();
		staff.setNome(nome);
		staff.setCognome(cognome);
		staff.setRuolo(ruolo);
		staff.setDataAssunzione(dataAssunzione);
		staff.setContratto(contratto);
		staff.setEmail(email);
		staff.setTelefono(telefono);
		staffService.registraStaff(staff, foto);
		return "redirect:/";  
	} 
}

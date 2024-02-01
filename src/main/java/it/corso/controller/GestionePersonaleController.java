package it.corso.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import it.corso.model.Staff;
import it.corso.service.StaffService;
import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/gestionepersonale")
public class GestionePersonaleController {
	@Autowired
	private StaffService staffService;
	
	@GetMapping
	public String getPage(Model model, HttpSession session) {
		// se non amministratore, ritorna all'home page
		if(session.getAttribute("amministratore") == null)
			return "redirect:/";
		
		// se amministratore visualizza la pagina
		List<Staff> staff = staffService.getAllStaff();
		model.addAttribute("staff", staff);

		return "gestionepersonale";
	}
	
	@GetMapping("/cancellastaff")
	public String gestioneCancellazione(@RequestParam("id") int id){
		staffService.cancellaStaff(staffService.getStaffById(id));
		return "redirect:/gestionepersonale";
	}
}

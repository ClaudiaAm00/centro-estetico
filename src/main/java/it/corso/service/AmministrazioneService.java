package it.corso.service;
import java.util.List;
import it.corso.model.Amministrazione;
import jakarta.servlet.http.HttpSession;


public interface AmministrazioneService {
	
	void registraAmministrazione(Amministrazione amministrazione);
	Amministrazione getAmministrazioneById(int id);
	List<Amministrazione> getAmministrazioni();
	void cancellaAmministrazione(Amministrazione amministrazione);

	boolean controlloLogin(String username, String password, HttpSession session);
}

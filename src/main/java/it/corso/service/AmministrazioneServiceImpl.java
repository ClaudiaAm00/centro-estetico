package it.corso.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.corso.dao.AmministrazioneDao;
import it.corso.model.Amministrazione;
import jakarta.servlet.http.HttpSession;


@Service
public class AmministrazioneServiceImpl implements AmministrazioneService {
	
	@Autowired
	private AmministrazioneDao amministrazioneDao;

	@Override
	public void registraAmministrazione(Amministrazione amministrazione) {
		amministrazioneDao.save(amministrazione);
	}

	@Override
	public Amministrazione getAmministrazioneById(int id) {
		
		return amministrazioneDao.findById(id).get();
	}

	@Override
	public List<Amministrazione> getAmministrazioni() {
		return (List<Amministrazione>) amministrazioneDao.findAll();
	}

	@Override
	public void cancellaAmministrazione(Amministrazione amministrazione) {
		amministrazioneDao.delete(amministrazione);

	}

	@Override
	public boolean controlloLogin(String username, String password, HttpSession session) {
		// prendo i valori validi dal database
		List<Amministrazione> amministratori = getAmministrazioni();
				
		// li confronto con quello che è stato scritto nel login
		for(Amministrazione p : amministratori) {
			if(username.equalsIgnoreCase(p.getUsername()) && password.equals(p.getPassword() )) {
				Amministrazione amministrazione = new Amministrazione();
				session.setAttribute("amministratore", amministrazione);
				return true;
			}
		}
		
		return false;
	
	}
	
}

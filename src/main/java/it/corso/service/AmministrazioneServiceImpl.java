package it.corso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.AmministrazioneDao;
import it.corso.model.Amministrazione;


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
		// 		return (List<Amministrazione>) amministrazioneDao.findAll();
		return (List<Amministrazione>) amministrazioneDao.findAll();
	}

	@Override
	public void cancellaAmministrazione(Amministrazione amministrazione) {
		amministrazioneDao.delete(amministrazione);

	}

}

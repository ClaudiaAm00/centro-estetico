package it.corso.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.corso.dao.PrestazioneDao;
import it.corso.model.Prestazione;


@Service
public class PrestazioneServiceImpl implements PrestazioneService {
	
	@Autowired
	private PrestazioneDao prestazioneDao;

	@Override
	public void registraPrestazione(Prestazione prestazione) 
	{
		prestazioneDao.save(prestazione);
	}

	@Override
	public Prestazione getPrestazioneById(int id) 
	{
		return prestazioneDao.findById(id).get();
	}

	@Override
	public List<Prestazione> getPrestazioni() 
	{
		return (List<Prestazione>) prestazioneDao.findAll();
	}

	@Override
	public void cancellaPrestazione(Prestazione prestazione) 
	{
		prestazioneDao.delete(prestazione);
	}

	@Override
	public List<Prestazione> listaNuovePrestazioni(int id) {
		return prestazioneDao.listaNuovePrestazioni(id);
	}

	@Override
	public List<Prestazione> trovaHair() {
		return prestazioneDao.trovaHair();
	}

	@Override
	public List<Prestazione> trovaBeauty() {
		return prestazioneDao.trovaBeauty();
	}

}

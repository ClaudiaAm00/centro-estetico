package it.corso.service;
import java.util.Base64;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import it.corso.dao.PrestazioneDao;
import it.corso.model.Prestazione;


@Service
public class PrestazioneServiceImpl implements PrestazioneService {
	
	@Autowired
	private PrestazioneDao prestazioneDao;

	@Override
	public void registraPrestazione(Prestazione prestazione, MultipartFile foto) 
	{
		if(foto != null && !foto.isEmpty())
		{
			try 
			{
				String estensione = foto.getContentType();
				System.out.println(estensione);
				prestazione.setFoto("data:" + estensione + ";base64," + Base64.getEncoder().encodeToString(foto.getBytes()));

			} catch (Exception e) 
			{
				System.out.println(e.getMessage());
			}
		}
		
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

package it.corso.service;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import it.corso.model.Prestazione;
import it.corso.model.Staff;


public interface PrestazioneService 
{
	void registraPrestazione(Prestazione prestazione, MultipartFile foto);
	Prestazione getPrestazioneById(int id);
	List<Prestazione> getPrestazioni();
	void cancellaPrestazione(Prestazione prestazione);
	void aggiornaPrestazione(Prestazione prestazione, MultipartFile foto, int id);
	
	List<Prestazione> listaNuovePrestazioni();
	List<Prestazione> trovaHair();
	List<Prestazione> trovaBeauty();
}

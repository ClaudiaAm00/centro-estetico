package it.corso.service;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import it.corso.model.Prestazione;


public interface PrestazioneService 
{
	void registraPrestazione(Prestazione prestazione, MultipartFile foto);
	Prestazione getPrestazioneById(int id);
	List<Prestazione> getPrestazioni();
	void cancellaPrestazione(Prestazione prestazione);
	
	List<Prestazione> listaNuovePrestazioni();
	List<Prestazione> trovaHair();
	List<Prestazione> trovaBeauty();
}

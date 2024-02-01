package it.corso.service;
import java.util.List;
import it.corso.model.Prestazione;


public interface PrestazioneService 
{
	void registraPrestazione(Prestazione prestazione);
	Prestazione getPrestazioneById(int id);
	List<Prestazione> getPrestazioni();
	void cancellaPrestazione(Prestazione prestazione);
}

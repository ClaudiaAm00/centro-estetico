package it.corso.service;
import java.util.List;
import it.corso.model.Contatti;

public interface ContattiService 
{
	void registraContatti(Contatti contatti);
	Contatti getContattiById(int id);
	List<Contatti> getAllContatti();
	void cancellaContatti(Contatti contatti);
}

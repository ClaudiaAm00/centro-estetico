package it.corso.dao;
import org.springframework.data.repository.CrudRepository;
import it.corso.model.Prestazione;

public interface PrestazioneDao extends CrudRepository<Prestazione, Integer>
{

}

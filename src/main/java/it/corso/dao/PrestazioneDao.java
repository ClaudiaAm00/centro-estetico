package it.corso.dao;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import it.corso.model.Prestazione;


public interface PrestazioneDao extends CrudRepository<Prestazione, Integer>
{

	// query per le nuove prestazioni offerte, limitata agli ultimi 5 record
	@Query(value = "SELECT * FROM prestazione ORDER BY id DESC LIMIT 5",	nativeQuery = true)
	List<Prestazione> listaNuovePrestazioni();
	
	// query hair
	@Query(value = "SELECT * FROM prestazione WHERE categoria = 'hair'", nativeQuery = true)
	List<Prestazione> trovaHair();
	
	// query beauty
	@Query(value = "SELECT * FROM prestazione WHERE categoria = 'beauty'", nativeQuery = true)
	List<Prestazione> trovaBeauty();
}

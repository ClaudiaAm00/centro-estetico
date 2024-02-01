package it.corso.dao;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import it.corso.model.Prestazione;


public interface PrestazioneDao extends CrudRepository<Prestazione, Integer>
{

	// query per le nuove prestazioni offerte, limitata agli ultimi 5 record
	@Query(value = "SELECT * FROM prestazione ORDER BY id=:p DESC LIMIT 5",	nativeQuery = true)
	List<Prestazione> listaNuovePrestazioni(@Param("p") int id);
	
}

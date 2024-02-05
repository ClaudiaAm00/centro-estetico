package it.corso.dao;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import it.corso.model.Staff;


public interface StaffDao extends CrudRepository<Staff, Integer>{

	// query staff dispari
		@Query(value = "SELECT * FROM staff WHERE id % 2 <> 0", nativeQuery = true)
		List<Staff> trovaStaffDispari();
		
}

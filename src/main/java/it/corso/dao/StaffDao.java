package it.corso.dao;
import org.springframework.data.repository.CrudRepository;
import it.corso.model.Staff;


public interface StaffDao extends CrudRepository<Staff, Integer>{

}

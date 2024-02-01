package it.corso.service;
import java.util.List;
import it.corso.model.Staff;


public interface StaffService {
	void registraStaff(Staff staff);
	Staff getStaffById(int id);
	List<Staff> getAllStaff();
	void cancellaStaff(Staff staff);
}

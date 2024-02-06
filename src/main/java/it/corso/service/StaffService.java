package it.corso.service;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import it.corso.model.Staff;


public interface StaffService {
	void registraStaff(Staff staff, MultipartFile foto);
	Staff getStaffById(int id);
	List<Staff> getAllStaff();
	void cancellaStaff(Staff staff);
	
	List<Staff> trovaStaffDispari();
	void aggiornaStaff(Staff staff, MultipartFile foto, int id);
}

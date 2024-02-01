package it.corso.service;
import java.util.Base64;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import it.corso.dao.StaffDao;
import it.corso.model.Staff;


@Service
public class StaffServiceImpl implements StaffService {
	@Autowired
	private StaffDao staffDao;

	@Override
	public void registraStaff(Staff staff, MultipartFile foto) {
		
		if(foto != null && !foto.isEmpty())
		{
			try 
			{
				String estensione = foto.getContentType();
				System.out.println(estensione);
				staff.setFoto("data:" + estensione + ";base64," + Base64.getEncoder().encodeToString(foto.getBytes()));

			} catch (Exception e) 
			{
				System.out.println(e.getMessage());
			}
		}
		
		staffDao.save(staff);
	}

	@Override
	public Staff getStaffById(int id) {
		return staffDao.findById(id).get();
	}

	@Override
	public List<Staff> getAllStaff() {
		return (List<Staff>) staffDao.findAll();
	}

	@Override
	public void cancellaStaff(Staff staff) {
		staffDao.delete(staff);
	}

}




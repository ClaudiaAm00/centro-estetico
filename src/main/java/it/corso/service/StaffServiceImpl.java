package it.corso.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.corso.dao.StaffDao;
import it.corso.model.Staff;


@Service
public class StaffServiceImpl implements StaffService {
	@Autowired
	private StaffDao staffDao;

	@Override
	public void registraStaff(Staff staff) {
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

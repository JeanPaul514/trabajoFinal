package pe.edu.upc.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.MembresiaDetails;
import pe.edu.upc.repository.MembresiaDetailsRepository;
import pe.edu.upc.service.IMembresiaDetailService;

@Service
public class MembresiaDetailServiceImpl implements IMembresiaDetailService {

	@Autowired
	private MembresiaDetailsRepository ideR;

	@Override
	public void delete(Long idMembresiaDetail) {
		ideR.deleteById(idMembresiaDetail);
	}

	@Override
	public Integer insert(MembresiaDetails impd) {
		MembresiaDetails impde = ideR.save(impd);
		if (impde == null) {
			return 0;
		} else {
			return 1;
		}
	}

}

package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.entities.Asesoria;
import pe.edu.upc.repository.AsesoriaRepository;
import pe.edu.upc.service.IAsesoriaService;

@Service
public class AsesoriaServiceImpl implements IAsesoriaService {
	@Autowired
	private AsesoriaRepository sR;

	@Override
	public void insert(Asesoria s) {
		sR.save(s);
	}

	@Override
	public List<Asesoria> list() {
		// TODO Auto-generated method stub
		return sR.findAll();
	}

	@Override
	public void delete(int id) {
		sR.deleteById(id);
	}


	

	
	
}

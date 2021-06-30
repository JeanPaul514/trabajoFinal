package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Membresia;
import pe.edu.upc.repository.MembresiaRepository;
import pe.edu.upc.service.IMembresiaService;

@Service
public class MembresiaServiceImpl implements IMembresiaService {
	@Autowired
	private MembresiaRepository sR;
	@Override
	public boolean insert(Membresia s) {
		Membresia imp = sR.save(s);
		if (imp == null) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public Membresia listarId(Long idMembresia) {
		Optional<Membresia> op = sR.findById(idMembresia);
		return op.isPresent() ? op.get() : new Membresia();
	}

	@Override
	public List<Membresia> listar() {
		return sR.findAll();
	}

	@Override
	public Optional<Membresia> fetchByImportIdWhithImportDetailsWithProduct(Long id) {
		return sR.fetchByImportIdWhithImportDetailsWithProduct(id);
	}

}

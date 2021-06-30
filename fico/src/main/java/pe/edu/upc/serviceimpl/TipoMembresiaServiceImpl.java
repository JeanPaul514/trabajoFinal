package pe.edu.upc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.TipoMembresia;
import pe.edu.upc.repository.TipoMembresiaRepository;
import pe.edu.upc.service.ITipoMembresiaService;

@Service
public class TipoMembresiaServiceImpl implements ITipoMembresiaService {

	@Autowired
	private TipoMembresiaRepository mR;

	@Override
	public void insert(TipoMembresia mc) {

		mR.save(mc);

	}

	@Override
	public List<TipoMembresia> list() {
		// TODO Auto-generated method stub
		return mR.findAll();
	}

	@Override
	public void delete(int id) {
		mR.deleteById(id);
	}

	@Override
	public List<String[]> prodXimp() {
		return mR.prodXimp();
	}

	@Override
	public List<String[]> prodXimp1() {
		// TODO Auto-generated method stub
		return mR.prodXimp1();
	}
	

}

package pe.edu.upc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Pago;
import pe.edu.upc.repository.PagoRepository;
import pe.edu.upc.service.IPagoService;

@Service
public class PagoImpl implements IPagoService {

	@Autowired
	private PagoRepository mR;

	@Override
	public void insert(Pago mc) {

		mR.save(mc);

	}

	@Override
	public List<Pago> list() {
		// TODO Auto-generated method stub
		return mR.findAll();
	}

	@Override
	public void delete(int id) {
		mR.deleteById(id);
	}

}

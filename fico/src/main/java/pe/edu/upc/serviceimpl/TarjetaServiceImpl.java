package pe.edu.upc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Tarjeta;
import pe.edu.upc.repository.TarjetaRepository;
import pe.edu.upc.service.ITarjetaService;

@Service
public class TarjetaServiceImpl implements ITarjetaService {

	@Autowired
	private TarjetaRepository mR;

	@Override
	public void insert(Tarjeta mc) {

		mR.save(mc);

	}

	@Override
	public List<Tarjeta> list() {
		// TODO Auto-generated method stub
		return mR.findAll();
	}

	@Override
	public void delete(int id) {
		mR.deleteById(id);
	}

}

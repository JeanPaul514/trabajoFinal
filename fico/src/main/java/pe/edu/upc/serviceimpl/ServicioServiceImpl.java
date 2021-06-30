package pe.edu.upc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Servicio;
import pe.edu.upc.repository.ServicioRepository;
import pe.edu.upc.service.IServicioService;

@Service
public class ServicioServiceImpl implements IServicioService {

	@Autowired
	private ServicioRepository mR;

	@Override
	public void insert(Servicio mc) {

		mR.save(mc);

	}

	@Override
	public List<Servicio> list() {
		// TODO Auto-generated method stub
		return mR.findAll();
	}

	@Override
	public void delete(int id) {
		mR.deleteById(id);
	}

}

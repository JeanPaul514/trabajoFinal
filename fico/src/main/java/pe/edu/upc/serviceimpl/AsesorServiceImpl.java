package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Asesor;
import pe.edu.upc.repository.AsesorRepository;
import pe.edu.upc.service.IAsesorService;

@Service
public class AsesorServiceImpl implements IAsesorService {
	@Override
	public List<Asesor> list() {
		// TODO Auto-generated method stub
		return mR.findAll();
	}

	@Autowired
	private AsesorRepository mR;
	@Transactional
	@Override
	
	public int insert(Asesor mc) {

		int rpta = mR.searchAsesor(mc.getNameAsesor());
		if (rpta == 0) {
			mR.save(mc);
		}
		return rpta;

	}

	@Override
	public void delete(int id) {
		mR.deleteById(id);
	}

	@Override
	public Optional<Asesor> listarId(int idAsesor) {
		// TODO Auto-generated method stub
		return mR.findById(idAsesor);

	}

	@Override
	public List<Asesor> findNameAsesorFull(String nameAsesor) {
		// TODO Auto-generated method stub
		return mR.findBynameAsesor(nameAsesor);

	}

}

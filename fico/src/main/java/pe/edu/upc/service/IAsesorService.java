package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entities.Asesor;

public interface IAsesorService {
	public int insert(Asesor mc);

	List<Asesor> list();

	public void delete(int id);
	Optional<Asesor>listarId(int idAsesor);
	List<Asesor> findNameAsesorFull(String nameAsesor);
}

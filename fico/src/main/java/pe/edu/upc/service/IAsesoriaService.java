package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entities.Asesoria;

public interface IAsesoriaService {
	public void insert(Asesoria s);
	public void delete(int id);
	List<Asesoria> list();

	
	
}

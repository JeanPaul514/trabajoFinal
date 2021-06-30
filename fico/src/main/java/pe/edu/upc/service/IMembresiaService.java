package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entities.Membresia;

public interface IMembresiaService {
	
	
	public boolean insert(Membresia membresia);

	Membresia listarId(Long idMembresia);

	List<Membresia> listar();

	Optional<Membresia> fetchByImportIdWhithImportDetailsWithProduct(Long id);
}

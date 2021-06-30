package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.TipoMembresia;

public interface ITipoMembresiaService {
	public void insert(TipoMembresia mc);

	List<TipoMembresia> list();

	public void delete(int id);
	public List<String[]> prodXimp();
	public List<String[]> prodXimp1();
}

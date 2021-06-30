package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.Servicio;

public interface IServicioService {
	public void insert(Servicio mc);

	List<Servicio> list();

	public void delete(int id);
}

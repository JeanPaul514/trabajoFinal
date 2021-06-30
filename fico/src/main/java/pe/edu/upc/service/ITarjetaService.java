package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.Tarjeta;

public interface ITarjetaService {
	public void insert(Tarjeta mc);

	List<Tarjeta> list();

	public void delete(int id);
}

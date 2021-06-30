package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.Pago;

public interface IPagoService {
	public void insert(Pago mc);

	List<Pago> list();

	public void delete(int id);
}

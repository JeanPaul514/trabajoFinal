package pe.edu.upc.service;

import pe.edu.upc.entities.MembresiaDetails;

public interface IMembresiaDetailService {
	public Integer insert(MembresiaDetails impd);

	public void delete(Long idMembresiaDetail);

}

package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.TipoMembresia;


@Repository
public interface TipoMembresiaRepository extends JpaRepository<TipoMembresia, Integer>{
	@Query( value="SELECT pr.name_tipoMembresia,sum(ide.priceTipoMembresia) from membresia i join membresia_details ide on  i.id_membresia = i.id_membresia join tipoMembresia pr on ide.id_tipoMembresia = pr.id_tipoMembresia group by pr.name_tipoMembresia",
			nativeQuery = true )
	public List<String[]> prodXimp();
	
	@Query( value="SELECT pr.name_tipoMembresia,sum(ide.priceTipoMembresia) from membresia i join membresia_details ide on  i.id_membresia = i.id_membresia join tipoMembresia pr on ide.id_tipoMembresia = pr.id_tipoMembresia group by pr.name_tipoMembresia ORDER BY sum(ide.priceTipoMembresia) DESC limit 1",
			nativeQuery = true )
	public List<String[]> prodXimp1();

}

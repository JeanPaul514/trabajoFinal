package pe.edu.upc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Membresia;

@Repository
public interface MembresiaRepository extends JpaRepository<Membresia, Long> {
	@Query("select i from Membresia i join fetch i.membresiaDetails ide join fetch ide.tipoMembresia where i.idMembresia=?1")
	Optional<Membresia> fetchByImportIdWhithImportDetailsWithProduct(Long id);

}

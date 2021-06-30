package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.MembresiaDetails;


@Repository
public interface MembresiaDetailsRepository extends JpaRepository<MembresiaDetails, Long> {
	

}

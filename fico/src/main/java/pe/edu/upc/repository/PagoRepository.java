package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Pago;


@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer>{

}

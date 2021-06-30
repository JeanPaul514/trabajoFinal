package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Servicio;


@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Integer>{

}

package pe.edu.upc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Tarjeta;


@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta, Integer>{
}

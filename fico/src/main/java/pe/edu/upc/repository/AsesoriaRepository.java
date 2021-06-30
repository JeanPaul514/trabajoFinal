package pe.edu.upc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Asesoria;

@Repository
public interface AsesoriaRepository extends JpaRepository<Asesoria, Integer> {

}

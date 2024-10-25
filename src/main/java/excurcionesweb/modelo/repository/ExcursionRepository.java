package excurcionesweb.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import excurcionesweb.modelo.entities.Excursion;



public interface ExcursionRepository extends JpaRepository<Excursion, Integer>{

	
}

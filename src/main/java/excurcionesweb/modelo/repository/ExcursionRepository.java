package excurcionesweb.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import excurcionesweb.modelo.entities.Excursion;



public interface ExcursionRepository extends JpaRepository<Excursion, Integer>{

	@Query("select e from Excursion e where e.destacado = 'S'")
	public List<Excursion> findByDestacados();
	@Query("select e from Excursion e where e.estado = 'CREADO'")
	public List<Excursion> findByCreados();
	@Query("select e from Excursion e where e.estado = 'CREADO'")
	public List<Excursion> findByCancelados();
	@Query("select e from Excursion e where e.estado = 'TERMINADO'")
	public List<Excursion> findByTerminados();
	
}

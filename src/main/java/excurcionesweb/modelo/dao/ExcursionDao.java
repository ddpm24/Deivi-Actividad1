package excurcionesweb.modelo.dao;

import java.util.List;

import excurcionesweb.modelo.entities.Excursion;

public interface ExcursionDao {

	Excursion findById(int idExcursion);
	List<Excursion> findAll();
	int insertOne(Excursion excursion);
	int updateOne(Excursion excursion);
	int deleteOne(Excursion excursion);
	int deleteOne(int idExcursion);
	int cancelOne(int idExcursion);
	List<Excursion> findByCreados();
	List<Excursion> findByCancelados();
	List<Excursion> findByDestacados();
	List<Excursion> findByTerminados();
	
	
	
}

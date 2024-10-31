package excurcionesweb.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import excurcionesweb.modelo.entities.Excursion;
import excurcionesweb.modelo.repository.ExcursionRepository;

@Repository
public class ExcursionDaoImplJpaMy8 implements ExcursionDao {

	@Autowired
	private ExcursionRepository erepo;
	
	@Override
	public Excursion findById(int idExcursion) {
		// TODO Auto-generated method stub
		 return erepo.findById(Integer.valueOf(idExcursion)).orElse(null);
	}

	@Override
	public List<Excursion> findAll() {
		// TODO Auto-generated method stub
		return erepo.findAll();
	}

	@Override
	public int insertOne(Excursion excursion) {
		// TODO Auto-generated method stub
		return (erepo.save(excursion) != null) ? 1 : 0;
	}

	@Override
	public int deleteOne(Excursion excursion) {
		// TODO Auto-generated method stub
		if (erepo.existsById(excursion.getIdExcursion())) {
			erepo.delete(excursion);
			return 1;
		}
		return 0;	
	}
	
	@Override
	public int deleteOne(int idExcursion) {
		if (erepo.existsById(idExcursion)) {
			erepo.deleteById(idExcursion);
			return 1;
		}
		return 0;
	}

	@Override
	public int cancelOne(int idExcursion) {
		if (erepo.existsById(idExcursion)) {
			Excursion excursion = erepo.findById(Integer.valueOf(idExcursion)).orElse(null);
			excursion.setEstado("CANCELADO");
			erepo.save(excursion);
			return 1;
		}
		return 0;
	}
	
	@Override
	public int updateOne(Excursion excursion) {
		// TODO Auto-generated method stub
		if (erepo.existsById(excursion.getIdExcursion())) {
			erepo.save(excursion);
			return 1;
		}
		return 0;
	}

	@Override
	public List<Excursion> findByCreados() {
		// TODO Auto-generated method stub
		return erepo.findByCreados();
	}

	@Override
	public List<Excursion> findByCancelados() {
		// TODO Auto-generated method stub
		return erepo.findByCancelados();
	}

	@Override
	public List<Excursion> findByDestacados() {
		// TODO Auto-generated method stub
		return erepo.findByDestacados();
	}

	@Override
	public List<Excursion> findByTerminados() {
		// TODO Auto-generated method stub
		return erepo.findByTerminados();
	}

	@Override
	public List<Excursion> findByEstado(String estado) {
		// TODO Auto-generated method stub
		return erepo.findByEstado(estado);
	}

	

	
	

}

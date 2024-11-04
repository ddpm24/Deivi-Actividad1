package excurcionesweb.modelo.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import excurcionesweb.modelo.entities.Excursion;
import excurcionesweb.modelo.repository.ExcursionRepository;

/**
 * Implementación del DAO de Excursión utilizando JPA y MySQL.
 */
@Repository
public class ExcursionDaoImplJpaMy8 implements ExcursionDao {

    @Autowired
    private ExcursionRepository erepo;

    /**
     * Busca una excursión por su ID.
     * 
     * @param idExcursion el ID de la excursión a buscar.
     * @return la excursión encontrada, o null si no existe.
     */
    @Override
    public Excursion findById(int idExcursion) {
        return erepo.findById(Integer.valueOf(idExcursion)).orElse(null);
    }

    /**
     * Obtiene una lista de todas las excursiones.
     * 
     * @return una lista de todas las excursiones disponibles.
     */
    @Override
    public List<Excursion> findAll() {
        return erepo.findAll();
    }

    /**
     * Inserta una nueva excursión en la base de datos.
     * 
     * @param excursion la excursión a insertar.
     * @return 1 si la operación fue exitosa, 0 en caso contrario.
     */
    @Override
    public int insertOne(Excursion excursion) {
        return (erepo.save(excursion) != null) ? 1 : 0;
    }

    /**
     * Elimina una excursión de la base de datos.
     * 
     * @param excursion la excursión a eliminar.
     * @return 1 si la operación fue exitosa, 0 si no se encontró la excursión.
     */
    @Override
    public int deleteOne(Excursion excursion) {
        if (erepo.existsById(excursion.getIdExcursion())) {
            erepo.delete(excursion);
            return 1;
        }
        return 0;    
    }

    /**
     * Elimina una excursión de la base de datos mediante su ID.
     * 
     * @param idExcursion el ID de la excursión a eliminar.
     * @return 1 si la operación fue exitosa, 0 si no se encontró la excursión.
     */
    @Override
    public int deleteOne(int idExcursion) {
        if (erepo.existsById(idExcursion)) {
            erepo.deleteById(idExcursion);
            return 1;
        }
        return 0;
    }

    /**
     * Cancela una excursión estableciendo su estado a "CANCELADO".
     * 
     * @param idExcursion el ID de la excursión a cancelar.
     * @return 1 si la operación fue exitosa, 0 si no se encontró la excursión.
     */
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

    /**
     * Actualiza los detalles de una excursión existente.
     * 
     * @param excursion la excursión con los datos actualizados.
     * @return 1 si la operación fue exitosa, 0 si no se encontró la excursión.
     */
    @Override
    public int updateOne(Excursion excursion) {
        if (erepo.existsById(excursion.getIdExcursion())) {
            erepo.save(excursion);
            return 1;
        }
        return 0;
    }

    /**
     * Encuentra excursiones con estado "CREADO".
     * 
     * @return una lista de excursiones con estado "CREADO".
     */
    @Override
    public List<Excursion> findByCreados() {
        return erepo.findByCreados();
    }

    /**
     * Encuentra excursiones con estado "CANCELADO".
     * 
     * @return una lista de excursiones con estado "CANCELADO".
     */
    @Override
    public List<Excursion> findByCancelados() {
        return erepo.findByCancelados();
    }

    /**
     * Encuentra excursiones destacadas.
     * 
     * @return una lista de excursiones destacadas.
     */
    @Override
    public List<Excursion> findByDestacados() {
        return erepo.findByDestacados();
    }

    /**
     * Encuentra excursiones con estado "TERMINADO".
     * 
     * @return una lista de excursiones con estado "TERMINADO".
     */
    @Override
    public List<Excursion> findByTerminados() {
        return erepo.findByTerminados();
    }

    /**
     * Encuentra excursiones según su estado.
     * 
     * @param estado el estado de las excursiones a buscar.
     * @return una lista de excursiones que coinciden con el estado proporcionado.
     */
    @Override
    public List<Excursion> findByEstado(String estado) {
        return erepo.findByEstado(estado);
    }

    /**
     * Busca excursiones cuyo precio esté dentro de un rango especificado.
     * 
     * @param precio1 el precio mínimo de las excursiones a buscar.
     * @param precio2 el precio máximo de las excursiones a buscar.
     * @return una lista de excursiones cuyo precio esté entre precio1 y precio2.
     */
    @Override
    public List<Excursion> buscarPorRangoPrecios(double precio1, double precio2) {
        return erepo.findByPrecioUnitarioGreaterThanEqualAndPrecioUnitarioLessThanEqual(precio1, precio2);
    }
}

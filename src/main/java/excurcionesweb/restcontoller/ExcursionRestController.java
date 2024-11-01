package excurcionesweb.restcontoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import excurcionesweb.modelo.dao.ExcursionDao;
import excurcionesweb.modelo.entities.Excursion;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/excursion")
public class ExcursionRestController {

	@Autowired
	ExcursionDao edao;
	
	
	// Obtener excursión por id
    @GetMapping("/{idExcursion}")
    public Excursion findById(@PathVariable int idExcursion) {
        return edao.findById(idExcursion);
    }

    // Obtener todas las excursiones
    @GetMapping("/all")
    public List<Excursion> findAll() {
        return edao.findAll();
    }

    // Insertar una nueva excursión
    @PostMapping("/add")
    public int insertOne(@RequestBody Excursion excursion) {
        return edao.insertOne(excursion);
    }

    // Actualizar una excursión existente
    @PutMapping("/update")
    public int updateOne(@RequestBody Excursion excursion) {
        return edao.updateOne(excursion);
    }

    // Obtener excursiones creadas
    @GetMapping("/creados")
    public List<Excursion> findByCreados() {
        return edao.findByCreados();
    }

    // Obtener excursiones canceladas
    @GetMapping("/cancelados")
    public List<Excursion> findByCancelados() {
        return edao.findByCancelados();
    }

    // Obtener excursiones destacadas
    @GetMapping("/destacados")
    public List<Excursion> findByDestacados() {
        return edao.findByDestacados();
    }

    // Obtener excursiones terminadas
    @GetMapping("/terminados")
    public List<Excursion> findByTerminados() {
        return edao.findByTerminados();
    }
    
    
    @GetMapping("/estado/{estado}")
    public List<Excursion> findByEstado(@PathVariable String estado) {
        return edao.findByEstado(estado);
    }
    
    @GetMapping("/precios/{precio1}/{precio2}")
    public List<Excursion> findByPrecios(@PathVariable double precio1,@PathVariable double precio2) {
        return edao.buscarPorRangoPrecios(precio1, precio2);
    }
	
	
}

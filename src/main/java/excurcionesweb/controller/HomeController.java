package excurcionesweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import excurcionesweb.modelo.dao.ExcursionDao;
import excurcionesweb.modelo.entities.Excursion;


/**
 * Controlador principal para manejar la página de inicio de la aplicación.
 * Muestra todas las excursiones disponibles en la vista principal.
 */
@Controller
public class HomeController {

    @Autowired
    private ExcursionDao excurcionDao;

    /**
     * Muestra la lista completa de excursiones en la página de inicio.
     * 
     * @param model objeto para añadir atributos a la vista.
     * @return la vista principal "home" con la lista de excursiones o un mensaje si no hay excursiones.
     */
    @GetMapping("/")
    public String home(Model model) {
        List<Excursion> lista = excurcionDao.findAll();
        
        if (lista == null || lista.isEmpty()) {
            model.addAttribute("mensaje", "No existen excursiones");
        } else {
            model.addAttribute("excursion", lista);
            model.addAttribute("mensaje", "Todas las excursiones existentes");
        }
        
        return "home";
    }
}
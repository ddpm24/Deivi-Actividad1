package excurcionesweb.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import excurcionesweb.modelo.dao.ExcursionDao;
import excurcionesweb.modelo.entities.Excursion;

/**
 * Controlador para gestionar las operaciones de las excursiones.
 */
@Controller
@RequestMapping("/excursion")
public class ExcursionController {

    @Autowired
    private ExcursionDao edao;

    /**
     * Muestra el detalle de una excursión específica.
     * 
     * @param model        objeto para añadir atributos a la vista.
     * @param idExcursion  ID de la excursión a mostrar.
     * @return la vista de detalles de la excursión si se encuentra, o redirige al inicio.
     */
    @GetMapping("/detalle/{idExcursion}")
    public String verDetalle(Model model, @PathVariable int idExcursion) {
        Excursion excursion = edao.findById(idExcursion);

        if (excursion != null) {
            model.addAttribute("excursion", excursion);
            return "VerDetalle";
        } else {
            model.addAttribute("mensaje", "Excursión no existe");
            return "forward:/";
        }
    }

    /**
     * Cancela una excursión por su ID.
     * 
     * @param idExcursion ID de la excursión a cancelar.
     * @param model       objeto para añadir mensajes a la vista.
     * @return redirige al inicio con un mensaje indicando el resultado de la cancelación.
     */
    @GetMapping("/eliminar/{idExcursion}")
    public String eliminar(@PathVariable int idExcursion, Model model) {
        if (edao.cancelOne(idExcursion) == 1) {
            model.addAttribute("mensaje", "Excursión Cancelada");
        } else {
            model.addAttribute("mensaje", "Excursión NO Cancelada");
        }
        return "forward:/";
    }

    /**
     * Muestra el formulario para dar de alta una nueva excursión.
     * 
     * @return la vista del formulario de alta de excursión.
     */
    @GetMapping("/alta")
    public String alta() {
        return "FormAltaExcursion";
    }

    /**
     * Procesa el formulario de alta para crear una nueva excursión.
     * 
     * @param excursion objeto de la excursión a insertar.
     * @param ratt      objeto para añadir mensajes de redirección.
     * @return redirige al inicio con un mensaje indicando el éxito o fracaso de la operación.
     */
    @PostMapping("/alta")
    public String procAlta(Excursion excursion, RedirectAttributes ratt) {
        excursion.setFechaAlta(new Date());
        if (edao.insertOne(excursion) == 1)
            ratt.addFlashAttribute("mensaje", "Excursión insertada correctamente");
        else
            ratt.addFlashAttribute("mensaje", "Excursión NO insertada");
        
        return "redirect:/";
    }

    /**
     * Muestra el formulario para editar una excursión específica.
     * 
     * @param model       objeto para añadir atributos a la vista.
     * @param idExcursion ID de la excursión a editar.
     * @return la vista del formulario de edición si la excursión existe, o redirige al inicio.
     */
    @GetMapping("/editar/{idExcursion}")
    public String mostrarFormEditar(Model model, @PathVariable int idExcursion) {
        Excursion excursion = edao.findById(idExcursion);

        if (excursion == null) {
            model.addAttribute("mensaje", "Excursión no existe");
            return "forward:/";
        }

        model.addAttribute("excursion", excursion);
        return "FormEditarExcursion";
    }

    /**
     * Procesa el formulario de edición para actualizar una excursión existente.
     * 
     * @param excursion   objeto de la excursión con los datos actualizados.
     * @param idExcursion ID de la excursión a actualizar.
     * @param ratt        objeto para añadir mensajes de redirección.
     * @return redirige al inicio con un mensaje indicando el éxito o fracaso de la operación.
     */
    @PostMapping("/editar/{idExcursion}")
    public String procFormEditar(Excursion excursion, @PathVariable int idExcursion, RedirectAttributes ratt) {
        excursion.setIdExcursion(idExcursion);
        if (edao.updateOne(excursion) == 1)
            ratt.addFlashAttribute("mensaje", "Excursión editada");
        else
            ratt.addFlashAttribute("mensaje", "Excursión NO editada");

        return "redirect:/";
    }

    /**
     * Muestra las excursiones destacadas.
     * 
     * @param model objeto para añadir atributos a la vista.
     * @return la vista principal con las excursiones destacadas o un mensaje si no existen.
     */
    @GetMapping("/destacados")
    public String destacados(Model model) {
        List<Excursion> excursion = edao.findByDestacados();

        if (excursion != null) {
            model.addAttribute("excursion", excursion);
            model.addAttribute("mensaje", "Excursiones destacadas");
            return "home";
        } else {
            model.addAttribute("mensaje", "No existen excursiones destacadas");
            return "home";
        }
    }

    /**
     * Muestra excursiones según su estado.
     * 
     * @param model  objeto para añadir atributos a la vista.
     * @param estado estado de las excursiones a buscar.
     * @return la vista principal con excursiones en el estado especificado o un mensaje si no existen.
     */
    @GetMapping("/findEstado/{estado}")
    public String mostrarFormEditar(Model model, @PathVariable String estado) {
        List<Excursion> excursion = edao.findByEstado(estado);

        if (excursion != null) {
            model.addAttribute("excursion", excursion);
            model.addAttribute("mensaje", "Excursiones en el estado " + estado);
            return "home";
        } else {
            model.addAttribute("mensaje", "No existen excursiones en este estado");
            return "forward:/";
        }
    }

    /**
     * Procesa la búsqueda de excursiones en un rango de precios.
     * 
     * @param precioMin precio mínimo del rango.
     * @param precioMax precio máximo del rango.
     * @param model     objeto para añadir atributos a la vista.
     * @return la vista principal con excursiones en el rango de precios especificado o un mensaje si no existen.
     */
    @PostMapping("/filtrarPorPrecio")
    public String procBuscarPorPrecio(@RequestParam double precioMin, 
                                      @RequestParam double precioMax, 
                                      Model model) {
        List<Excursion> excursionesFiltradas = edao.buscarPorRangoPrecios(precioMin, precioMax);

        if (excursionesFiltradas != null && !excursionesFiltradas.isEmpty()) {
            model.addAttribute("mensaje", "Excursiones con el precio entre " + precioMin + " y " + precioMax);
        } else {
            model.addAttribute("mensaje", "No existen excursiones en ese rango");
        }

        model.addAttribute("excursionesFiltradas", excursionesFiltradas);
        return "home";
    }

    /**
     * Muestra la lista completa de excursiones en la vista principal.
     * 
     * @param model objeto para añadir atributos a la vista.
     * @return la vista principal con la lista de todas las excursiones.
     */
    @GetMapping("/filtrar")
    public String home(Model model) {
        List<Excursion> lista = edao.findAll();
        model.addAttribute("excursion", lista);
        return "home";
    }
}
package excurcionesweb.controller;

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

@Controller
@RequestMapping("/excursion")
public class ExcursionController {

	@Autowired
	private ExcursionDao edao;
	
	@GetMapping("/detalle/{idExcursion}")
	public String verDetalle(Model model, @PathVariable int idExcursion) {
		
		Excursion excursion = edao.findById(idExcursion);
		
		if (excursion != null) {
			model.addAttribute("excursion", excursion);
			return "VerDetalle";
		} else {
			model.addAttribute("mensaje", "excursion no existe");
			return "forward:/";
		}
		
	}
	
	@GetMapping("/eliminar/{idExcursion}")
	public String eliminar(@PathVariable int idExcursion, Model model) {
		
		if (edao.cancelOne(idExcursion) == 1) {
			model.addAttribute("mensaje","Excursión Cancelada");
		} else {
			model.addAttribute("mensaje","Excursión NO Cancelada");
		}
		
		return "forward:/";
	}
	
	@GetMapping("/alta")
	public String alta() {
		return "FormAltaExcursion";
	}
	
	@PostMapping("/alta")
	public String procAlta(Excursion excursion, RedirectAttributes ratt) {
		
		if (edao.insertOne(excursion) == 1)
			ratt.addFlashAttribute("mensaje", "Excursión insertada correctamente.");
		else
			ratt.addFlashAttribute("mensaje", "Excursión NO insertada.");
		
		return "redirect:/";
	}
	
	@GetMapping("/editar/{idExcursion}")
	public String mostrarFormEditar(Model model, @PathVariable int idExcursion) {
		
		Excursion excursion = edao.findById(idExcursion);
		
		if (excursion == null) {
			model.addAttribute("mensaje", "Excursion no existe");
			return "forward:/";
		}
		
		model.addAttribute("excursion", excursion);
		return "FormEditarExcursion";
	}
	
	@PostMapping("/editar/{idExcursion}")
	public String procFormEditar(Excursion excursion, @PathVariable int idExcursion, RedirectAttributes ratt) {
		
		excursion.setIdExcursion(idExcursion);
		if (edao.updateOne(excursion) == 1)
			ratt.addFlashAttribute("mensaje", "Excursion editada.");
		else
			ratt.addFlashAttribute("mensaje", "Excursion NO editada.");
		
		
		return "redirect:/";
	}

	
	@GetMapping("/creados")
	public String creados(Model model) {
		
		List<Excursion> excursion = edao.findByCreados();
		
		if (excursion != null) {
			model.addAttribute("excursiones", excursion);
			return "TabCreados";
		} else {
			model.addAttribute("mensaje", "no existen excursiones en este estado.");
			return "forward:/";
		}
		
	}
	
	@GetMapping("/destacados")
	public String destacados(Model model) {
		
		List<Excursion> excursion = edao.findByDestacados();
		
		if (excursion != null) {
			model.addAttribute("excursion", excursion);
			model.addAttribute("mensaje", "Excursiones destacadas.");
			return "home";
		} else {
			model.addAttribute("mensaje", "no existen excursiones en este estado.");
			return "home";
		}
		
	}
	
	@GetMapping("/terminados")
	public String terminados(Model model) {
		
		List<Excursion> excursiones = edao.findByTerminados();
		
		if (excursiones != null) {
			model.addAttribute("excursiones", excursiones);
			return "TabCreados";
		} else {
			model.addAttribute("mensaje", "no existen excursiones en este estado.");
			return "forward:/";
		}
		
	}
	
	
	@GetMapping("/findEstado/{estado}")
	public String mostrarFormEditar(Model model, @PathVariable String estado) {
		System.out.println(estado);
		List<Excursion> excursion = edao.findByEstado(estado);
		System.out.println(excursion);
		
		if (excursion != null) {
			model.addAttribute("excursion", excursion);
			model.addAttribute("mensaje", "Excursiones en el estado "+estado+".");
			return "home";
		} else {
			model.addAttribute("mensaje", "no existen excursiones en este estado.");
			return "forward:/";
		}
		
	}
	
	
	@PostMapping("/filtrarPorPrecio")
	public String procBuscarPorPrecio(@RequestParam("precioMin") double precioMin, 
	                                  @RequestParam("precioMax") double precioMax, 
	                                  Model model) {
		
	    List<Excursion> excursionesFiltradas = edao.buscarPorRangoPrecios(precioMin, precioMax);

	    
	    if (excursionesFiltradas != null && !excursionesFiltradas.isEmpty()) {
	        model.addAttribute("mensaje", "Excurciones con el precio entre "+ precioMin +" y "+precioMax+".");
	    } else {
	        model.addAttribute("mensaje", "No existen excursiones en ese rango.");
	    }

	    model.addAttribute("excursionesFiltradas", excursionesFiltradas);

	    return "home";  
	}
	
	
}

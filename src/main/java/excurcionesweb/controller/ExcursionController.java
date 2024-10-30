package excurcionesweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}

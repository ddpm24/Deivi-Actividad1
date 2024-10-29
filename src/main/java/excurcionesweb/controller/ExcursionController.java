package excurcionesweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
}

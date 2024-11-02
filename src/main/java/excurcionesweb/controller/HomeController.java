package excurcionesweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import excurcionesweb.modelo.dao.ExcursionDao;
import excurcionesweb.modelo.entities.Excursion;


@Controller
public class HomeController {

	@Autowired
	private ExcursionDao excurcionDao;
	
	@GetMapping("/")
	public String home(Model model) {
		List<Excursion> lista = excurcionDao.findAll();  
		if (lista == null)
			model.addAttribute("mensaje", "No existen excurciones");
		else {
			model.addAttribute("excursion", excurcionDao.findAll());
			model.addAttribute("mensaje", "Todas las excurciones existentes");
		}
		return "home";
	}
	
}

package pe.edu.upc.controller;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.entities.Asesoria;
import pe.edu.upc.service.IAsesorService;
import pe.edu.upc.service.IAsesoriaService;
import pe.edu.upc.service.IServicioService;


@Controller
@RequestMapping("/asesoria")

public class AsesoriaController {
	@Autowired
	private IAsesoriaService sService;
	@Autowired
	private IAsesorService mService;
	@Autowired
	private IServicioService oService;

	@GetMapping("/new")
	public String newSpecialty(Model model) {
		model.addAttribute("asesoria", new Asesoria());
		model.addAttribute("listaAsesor", mService.list());
		model.addAttribute("listaServicio",oService.list());
		return "asesoria/asesoria";
	}

	@PostMapping("/save")
	public String saveAsesoria(@Valid @ModelAttribute(value = "asesoria") Asesoria asesoria, BindingResult result,
			Model model, SessionStatus status) throws Exception {

		if (result.hasErrors()) {
			model.addAttribute("listaAsesor", mService.list());
			model.addAttribute("listaServicio",oService.list());
			return "asesoria/asesoria";
		} else {
			sService.insert(asesoria);
			model.addAttribute("mensaje", "Se realizó bien!!");
			status.setComplete();
			return "redirect:/asesoria/list";
		}

	}

	@GetMapping("/list")
	public String listAsesoria(Model model) {
		try {
			model.addAttribute("listaAsesoria", sService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "asesoria/listAsesoria";
	}

	@RequestMapping("/delete")
	public String deleteAsesoria(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {

			if (id != null && id > 0) {
				sService.delete(id);
				model.put("mensaje", "Se eliminó correctamente!!");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrió un error");
		}

		return "redirect:/asesoria/list";

	}

	
	
	
	
}

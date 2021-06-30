package pe.edu.upc.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.entities.Asesor;
import pe.edu.upc.service.IAsesorService;

@Controller
@RequestMapping("/asesor")
@Secured("ROLE_ADMIN")
public class AsesorController {
	@Autowired
	private IAsesorService mService;

	/* localhost:8082/medics/ */

	@GetMapping("/new")
	public String newAsesor(Model model) {
		model.addAttribute("asesor", new Asesor());
		return "asesor/asesor";
	}

	@PostMapping("/save")
	public String saveAsesor(@Valid @ModelAttribute(value = "asesor") Asesor asesor, BindingResult result,
			Model model, SessionStatus status) throws Exception {

		if (result.hasErrors()) {
			return "asesor/asesor";
		} else {
			mService.insert(asesor);
			model.addAttribute("mensaje", "Se realizó bien!!");
			status.setComplete();
			return "redirect:/asesor/list";
		}

	}

	@GetMapping("/list")
	public String listAsesor(Model model) {
		try {
			model.addAttribute("asesor", new Asesor());

			model.addAttribute("listaAsesor", mService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "asesor/listAsesor";
	}

	
	
	@RequestMapping("/delete")
	public String deleteAsesor(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {

			if(id!=null && id>0) {
				mService.delete(id);
				model.put("mensaje", "Se eliminó correctamente!!");
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrió un error");
		}

		return "redirect:/asesor/list";

	}
	@GetMapping("/detalle/{id}")
	public String viewAsesor(@PathVariable(value="id")int id, Model model) {
		try {
			Optional<Asesor> asesor=mService.listarId(id);
			if (!asesor.isPresent()) {
				model.addAttribute("mensaje","Asesor no exite");
				return "redirect:/asesor/list";
			} else {
				model.addAttribute("asesor",asesor.get());
				return "asesor/asesor";
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "asesor/asesor";
	}
	@RequestMapping("/search")
	public String searchAsesor(Model model, @ModelAttribute Asesor asesor) throws ParseException {
		model.addAttribute("asesor", new Asesor());

		List<Asesor> listAsesor;
		
		asesor.setNameAsesor(asesor.getNameAsesor());
		listAsesor = mService.findNameAsesorFull(asesor.getNameAsesor());
		if (listAsesor.isEmpty()) {

			model.addAttribute("mensaje", "No se encontró");
		}
		model.addAttribute("listaAsesor", listAsesor);
		return "asesor/listAsesor";

	}
	
}

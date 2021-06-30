package pe.edu.upc.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.entities.Servicio;
import pe.edu.upc.service.IServicioService;

@Controller
@RequestMapping("/servicio")
public class ServicioController {
	@Autowired
	private IServicioService mService;

	/* localhost:8082/medics/ */

	@GetMapping("/new")
	public String newServicio(Model model) {
		model.addAttribute("servicio", new Servicio());
		return "servicio/servicio";
	}

	@PostMapping("/save")
	public String saveServicio(@Valid @ModelAttribute(value = "servicio") Servicio servicio, BindingResult result,
			Model model, SessionStatus status) throws Exception {

		if (result.hasErrors()) {
			return "servicio/servicio";
		} else {
			mService.insert(servicio);
			model.addAttribute("mensaje", "Se realizó bien!!");
			status.setComplete();
			return "redirect:/servicio/list";
		}

	}

	@GetMapping("/list")
	public String listServicio(Model model) {
		try {
			model.addAttribute("listaServicio", mService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "servicio/listServicio";
	}

	
	
	@RequestMapping("/delete")
	public String deleteServicio(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {

			if(id!=null && id>0) {
				mService.delete(id);
				model.put("mensaje", "Se eliminó correctamente!!");
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrió un error");
		}

		return "redirect:/servicio/list";

	}

}

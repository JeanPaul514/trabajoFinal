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

import pe.edu.upc.entities.Tarjeta;
import pe.edu.upc.service.ITarjetaService;

@Controller
@RequestMapping("/tarjeta")
public class TarjetaController {
	@Autowired
	private ITarjetaService mService;

	/* localhost:8082/tarjeta/ */

	@GetMapping("/new")
	public String newTarjeta(Model model) {
		model.addAttribute("tarjeta", new Tarjeta());
		return "tarjeta/tarjeta";
	}

	@PostMapping("/save")
	public String saveTarjeta(@Valid @ModelAttribute(value = "tarjeta") Tarjeta tarjeta, BindingResult result,
			Model model, SessionStatus status) throws Exception {

		if (result.hasErrors()) {
			return "tarjeta/tarjeta";
		} else {
			mService.insert(tarjeta);
			model.addAttribute("mensaje", "Se realizó bien!!");
			status.setComplete();
			return "redirect:/tarjeta/list";
		}

	}

	@GetMapping("/list")
	public String listTarjeta(Model model) {
		try {
			model.addAttribute("listaTarjeta", mService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "tarjeta/listTarjeta";
	}

	
	
	@RequestMapping("/delete")
	public String deleteTarjeta(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {

			if(id!=null && id>0) {
				mService.delete(id);
				model.put("mensaje", "Se eliminó correctamente!!");
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrió un error");
		}

		return "redirect:/tarjeta/list";

	}

}

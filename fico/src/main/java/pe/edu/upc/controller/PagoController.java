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

import pe.edu.upc.entities.Pago;
import pe.edu.upc.service.IPagoService;

@Controller
@RequestMapping("/pago")
public class PagoController {
	@Autowired
	private IPagoService mService;

	/* localhost:8082/medics/ */

	@GetMapping("/new")
	public String newPago(Model model) {
		model.addAttribute("pago", new Pago());
		return "pago/pago";
	}

	@PostMapping("/save")
	public String savePago(@Valid @ModelAttribute(value = "pago") Pago pago, BindingResult result,
			Model model, SessionStatus status) throws Exception {

		if (result.hasErrors()) {
			return "pago/pago";
		} else {
			mService.insert(pago);
			model.addAttribute("mensaje", "Se realizó bien!!");
			status.setComplete();
			return "redirect:/pago/list";
		}

	}

	@GetMapping("/list")
	public String listPago(Model model) {
		try {
			model.addAttribute("listaPago", mService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "pago/listPago";
	}

	
	
	@RequestMapping("/delete")
	public String deletePago(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {

			if(id!=null && id>0) {
				mService.delete(id);
				model.put("mensaje", "Se eliminó correctamente!!");
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrió un error");
		}

		return "redirect:/pago/list";

	}

}

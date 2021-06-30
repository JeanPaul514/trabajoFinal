package pe.edu.upc.controller;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.entities.Cliente;
import pe.edu.upc.service.IClienteService;
import pe.edu.upc.service.ITarjetaService;

@Controller
@RequestMapping("/cliente")
@Secured("ROLE_ADMIN")

public class ClienteController {
	@Autowired
	private IClienteService sService;
	@Autowired
	private ITarjetaService mService;

	@GetMapping("/new")
	public String newCliente(Model model) {
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("listaTarjeta", mService.list());
		return "cliente/cliente";
	}

	@PostMapping("/save")
	public String saveCliente(@Valid @ModelAttribute(value = "cliente") Cliente cliente, BindingResult result,
			Model model, SessionStatus status) throws Exception {

		if (result.hasErrors()) {
			model.addAttribute("listaTarjeta", mService.list());
			return "cliente/cliente";
		} else {
			sService.insert(cliente);
			model.addAttribute("mensaje", "Se realizó bien!!");
			status.setComplete();
			return "redirect:/cliente/list";
		}

	}

	@GetMapping("/list")
	public String listCliente(Model model) {
		try {
			model.addAttribute("listaCliente", sService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "cliente/listCliente";
	}

	@RequestMapping("/delete")
	public String deleteCliente(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {

			if (id != null && id > 0) {
				sService.delete(id);
				model.put("mensaje", "Se eliminó correctamente!!");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrió un error");
		}

		return "redirect:/cliente/list";
	}
	@RequestMapping("/irupdate/{id}")
	public String irUpdate(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<Cliente> objAr = sService.searchId(id);
		if (objAr == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/cliente/list";
		} else {
			model.addAttribute("listaTarjeta", mService.list());
			model.addAttribute("cliente", objAr.get());
			return "cliente/cliente";
		}
	}

}

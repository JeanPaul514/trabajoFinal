package pe.edu.upc.controller;

import java.util.Date;
import java.util.Map;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.entities.Membresia;
import pe.edu.upc.entities.MembresiaDetails;
import pe.edu.upc.service.ITipoMembresiaService;
import pe.edu.upc.service.IMembresiaDetailService;
import pe.edu.upc.service.IMembresiaService;

@Controller
@RequestMapping("/membresia")
public class MembresiaController {
	@Autowired
	private IMembresiaService sService;
	@Autowired
	private ITipoMembresiaService mService;
	@Autowired
	private IMembresiaDetailService pService;
	@RequestMapping("/reports")
	public String Report()
	{
		return "reports/reports";
	}
	@GetMapping("/new")
	public String newMembresia(Model model) {
		model.addAttribute("membresia", new Membresia());
		return "membresia/membresia";
	}
	@RequestMapping("/newtipoMembresia/{id}")
	public String irNewProduct(@PathVariable(value = "id") Long id, Map<String, Object> model) {

		model.put("detail", new MembresiaDetails());
		model.put("listaTipoMembresia", mService.list());

		Membresia objmem = sService.listarId(id);
		model.put("membresia", objmem);

		return "membresia/details/detailForm";
	}
	@RequestMapping("/list")
	public String listar(Map<String, Object> model) {
		model.put("listaMembresia", sService.listar());
		return "membresia/listMembresia";
	}
	@GetMapping("/detail/{id}")
	public String detailImportation(@PathVariable(value = "id") Long id, Map<String, Object> model,
			RedirectAttributes flash) {
		Membresia mem = sService.listarId(id);

		if (mem == null) {
			flash.addFlashAttribute("error", "El Detalle no existe en la base de datos");
			return "membresia/listMembresia"; 
		}
		model.put("membresia", mem);
		model.put("titulo", "Detalle de Importacion #" + mem.getIdMembresia());

		return "membresia/details/listDetail"; 
	}
	
	@PostMapping("/save")
	public String saveOrder(@Valid Membresia membresia, Model model, SessionStatus status, BindingResult binRes) {
		Date requestday = new Date();
		try {
			membresia.setRequestDate(requestday);
			sService.insert(membresia);
			status.setComplete();
			model.addAttribute("success", "Orden Generada");
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "redirect: /membresia/new";
		}

		return "redirect:/membresia/list";
	}

	
	
	@PostMapping("/savetipoMembresia{id}")
	public String newProductXImportation(@PathVariable(value = "id") long id, @Valid MembresiaDetails membresiaDetails,
			RedirectAttributes flash, BindingResult result, Model model, SessionStatus status) {
		Membresia mem = sService.listarId(id);
		if (result.hasErrors()) {
			flash.addFlashAttribute("error", "El valor debe ser positivo");
			String cadena1 = "redirect:/membresia/newtipoMembresia/" + id;
			return cadena1;
		}
		try {
			mem.addDetailMembresia(membresiaDetails);
			sService.insert(mem);
			status.isComplete();
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			System.out.println(e.getMessage());
		}
		String cadena = "redirect:/membresia/detail/" + id;
		return cadena;
	}
	@RequestMapping("{idmem}/eliminardetail/{id}")
	public String eliminarDetalle(Map<String, Object> model, @PathVariable(value = "id") Long idet,
			@PathVariable(value = "idmem") Long idmem, RedirectAttributes flash) {
		try {
			if (idet != null && idet > 0) {
				pService.delete(idet);
				flash.addAttribute("mensaje", "Se eliminó correctamente");
				flash.addAttribute("mensaje1", "Se eliminó correctamente el id" + idet);
			} else
				return "redirect:/home";
		} catch (Exception e) {
			model.put("mensaje", "No se puede eliminar");
			model.put("error", e.getMessage());
		}
		String cadena = "redirect:/membresia/detail/" + idmem;
		return cadena;
	}
	

}

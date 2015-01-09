package es.pruebas.html5.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import es.pruebas.html5.service.BolsaService;
import es.pruebas.html5.web.bean.JSONResponse;
import es.pruebas.html5.web.bean.bolsa.AccionBean;
import es.pruebas.html5.web.form.AccionForm;

@Controller
@RequestMapping("/bolsa")
public class BolsaController {
	
	@Autowired
	private BolsaService bolsaService;

	@RequestMapping (method = RequestMethod.GET, produces="application/json")
	@ResponseBody	
	public JSONResponse<AccionBean> getAcciones () {
		JSONResponse<AccionBean> response = new JSONResponse<AccionBean>();
		response.setSuccess(true);
		response.setData(bolsaService.getAcciones());		
		return response;
	}
	
	
	
	
	
	@RequestMapping (value="/admin", method = RequestMethod.GET)
	public ModelAndView formGestionarMercados() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("accionForm", new AccionForm());
		mav.addObject("accionesBolsa", bolsaService.getAcciones());
		mav.setViewName("bolsa/detalleAdmin");
		return mav;
	}
	
	
	@RequestMapping (value="/admin", method = RequestMethod.POST)
	public ModelAndView gestionarMercadosActualizarAccion(@ModelAttribute("accionForm") AccionForm accionForm) {
		
		bolsaService.insertarOActualizarAccion(accionForm.getAccionBean());
		return new ModelAndView("redirect:/bolsa/admin");
	}
	
	
}

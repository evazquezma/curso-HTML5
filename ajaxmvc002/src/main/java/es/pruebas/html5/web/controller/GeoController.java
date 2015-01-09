package es.pruebas.html5.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import es.pruebas.html5.web.bean.JSONResponse;
import es.pruebas.html5.web.bean.geo.ComunidadBean;
import es.pruebas.html5.web.bean.geo.ProvinciaBean;

@Controller
@RequestMapping("/geo")
public class GeoController {
	private List<ComunidadBean> comunidades;
	private Map<Long, List<ProvinciaBean>> provincias;
	
	@PostConstruct
	public void setup() {
		comunidades = new ArrayList<ComunidadBean>();
		comunidades.add(new ComunidadBean(100l, "Galicia"));
		comunidades.add(new ComunidadBean(200l, "Extremadura"));
		comunidades.add(new ComunidadBean(300l, "Aragon"));
		
		
		 provincias = new HashMap<Long,  List<ProvinciaBean>>();
		 provincias.put(100l, new ArrayList<ProvinciaBean>());
		 provincias.get(100l).add(new ProvinciaBean(101l, "Coruña"));
		 provincias.get(100l).add(new ProvinciaBean(102l, "Lugo"));
		 provincias.get(100l).add(new ProvinciaBean(103l, "Orense"));
		 provincias.get(100l).add(new ProvinciaBean(104l, "Pontevedra"));
		 		 
		 provincias.put(200l, new ArrayList<ProvinciaBean>());
		 provincias.get(200l).add(new ProvinciaBean(201l, "Caceres"));
		 provincias.get(200l).add(new ProvinciaBean(202l, "Badajoz"));		 
		 		 
		 provincias.put(300l, new ArrayList<ProvinciaBean>());
		 provincias.get(300l).add(new ProvinciaBean(301l, "Huesca"));
		 provincias.get(300l).add(new ProvinciaBean(302l, "Zaragoza"));
		 provincias.get(300l).add(new ProvinciaBean(303l, "Teruel"));		 		 				
	}
	
	
	
	@RequestMapping(value="/comunidades", method = RequestMethod.GET, produces="application/json")
	@ResponseBody	
	private JSONResponse<ComunidadBean> getComunicades () {
		JSONResponse<ComunidadBean> response = new JSONResponse<ComunidadBean>();
		response.setSuccess(true);
		response.setData(comunidades);		
		return response;
	}

	
	
	@RequestMapping(value="/provincias", method = RequestMethod.GET,  produces="application/json")
	@ResponseBody
	private JSONResponse<ProvinciaBean> getProvincias (@RequestParam(value = "idComunidad", required = true) Long idComunidad) {
		JSONResponse<ProvinciaBean> response = new JSONResponse<ProvinciaBean>();
		
		if (provincias.containsKey(idComunidad)) {
			response.setSuccess(true);
			response.setData(provincias.get(idComunidad));
		}
		else {
			response.setSuccess(false);			
		}
		
		return response;
	}
}

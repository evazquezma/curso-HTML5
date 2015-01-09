package es.pruebas.html5.web.controller;

import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import es.pruebas.html5.web.bean.info.InfoBean;

@Controller
@RequestMapping("/info")
public class InfoController {

	
	@RequestMapping (method = RequestMethod.GET, produces="application/json")
	@ResponseBody	
	private InfoBean getInfo () {
		InfoBean info = new InfoBean();
		info.setFecha(new Date());
		info.setNumero(new Random().nextInt());
		return info;
	}
}

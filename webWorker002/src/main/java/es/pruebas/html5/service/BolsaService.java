package es.pruebas.html5.service;

import java.util.List;

import es.pruebas.html5.web.bean.bolsa.AccionBean;

public interface BolsaService {

	public List<AccionBean> getAcciones();

	public void insertarOActualizarAccion(AccionBean accionBean);
	
}

package es.pruebas.html5.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import es.pruebas.html5.service.util.AccionBeanComparator;
import es.pruebas.html5.web.bean.bolsa.AccionBean;

@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) //No hace falta ponerlo porque, por defecto, todos los beans son singleton
@Service("bolsaService")
public class BolsaServiceImpl implements BolsaService {
	private List<AccionBean> acciones;
	
	
	@PostConstruct
	public void init() {
		acciones = new ArrayList<AccionBean>();
		
		acciones.add(new AccionBean ("Indra", 12f, 1.0f));
		acciones.add(new AccionBean ("Dragados", 20f, -0.5f));
		acciones.add(new AccionBean ("Inditext", 15f, 2.0f));
		acciones.add(new AccionBean ("Santander", 7f, -2.0f));
		
		Collections.sort(acciones, new AccionBeanComparator());
	}

	
	
	@Override
	public List<AccionBean> getAcciones() {
		List<AccionBean> acciones2 = null;
		
		//Hacer la lista de acciones thread safe
		synchronized (this) {
			acciones2 = new ArrayList<AccionBean>(acciones);
		}
		return acciones2;
	}



	@Override
	public void insertarOActualizarAccion(AccionBean accionBean) {
		//Hacer la lista de acciones thread safe
		synchronized (this) {						
			if (acciones.contains(accionBean)) {
				acciones.remove(acciones.indexOf(accionBean));			
			}
			
			acciones.add(accionBean);
			Collections.sort(acciones, new AccionBeanComparator());
		}		
	}
	
}

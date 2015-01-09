package es.pruebas.html5.service.util;

import java.util.Comparator;

import es.pruebas.html5.web.bean.bolsa.AccionBean;

public class AccionBeanComparator implements Comparator<AccionBean>{

	@Override
	public int compare(AccionBean o1, AccionBean o2) {		
		return o1.getEmpresa().compareTo(o2.getEmpresa());
	}

}

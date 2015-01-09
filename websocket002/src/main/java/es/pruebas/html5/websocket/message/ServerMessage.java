package es.pruebas.html5.websocket.message;

import java.util.List;

import es.pruebas.html5.web.bean.bolsa.AccionBean;

public class ServerMessage {
	private String codigo;
	private List<AccionBean> acciones;
	
	
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public List<AccionBean> getAcciones() {
		return acciones;
	}
	public void setAcciones(List<AccionBean> acciones) {
		this.acciones = acciones;
	}		
}

package es.pruebas.html5.web.bean.geo;

public class ComunidadBean {
	private Long id;	
	private String nombre;
		
	public ComunidadBean() {}
	
	public ComunidadBean(Long id, String nombre) {	
		this.id = id;
		this.nombre = nombre;
	}
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
}
package es.pruebas.html5.web.bean.bolsa;

public class AccionBean {
	private String empresa;
	private Float valorAccion;
	private Float variacion;
	
	
	public AccionBean() {}

	public AccionBean(String empresa, Float valorAccion, Float variacion) {
		this.empresa = empresa;
		this.valorAccion = valorAccion;
		this.variacion = variacion;
	}
	
	
	
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public Float getValorAccion() {
		return valorAccion;
	}
	public void setValorAccion(Float valorAccion) {
		this.valorAccion = valorAccion;
	}
	public Float getVariacion() {
		return variacion;
	}
	public void setVariacion(Float variacion) {
		this.variacion = variacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccionBean other = (AccionBean) obj;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AccionBean [empresa=" + empresa + ", valorAccion="
				+ valorAccion + ", variacion=" + variacion + "]";
	}	
}

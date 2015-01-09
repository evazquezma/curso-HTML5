package es.pruebas.html5.web.bean;

import java.util.List;

public class JSONResponse <T> {
	public boolean success;
	public List<T> data;
	
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}	
}

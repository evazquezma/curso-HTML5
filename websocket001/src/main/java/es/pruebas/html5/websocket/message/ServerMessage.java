package es.pruebas.html5.websocket.message;

public class ServerMessage {
	private String codigo;
	private String mensaje;
	
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	@Override
	public String toString() {
		return "ServerMessage [codigo=" + codigo + ", mensaje=" + mensaje + "]";
	}
}

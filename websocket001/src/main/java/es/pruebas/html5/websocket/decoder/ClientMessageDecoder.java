package es.pruebas.html5.websocket.decoder;



import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import org.codehaus.jackson.map.ObjectMapper;

import es.pruebas.html5.websocket.message.ClientMessage;


public class ClientMessageDecoder implements Decoder.Text<ClientMessage> {
	
    @Override
    public void init(EndpointConfig ec) { }
    
    @Override
    public void destroy() { }

	@Override
	public ClientMessage decode(String s) throws DecodeException {
		ClientMessage message = null;
		try {
			message = new ObjectMapper().readValue(s, ClientMessage.class);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return message;
	}

	@Override
	public boolean willDecode(String s) {
		return true;
	}
      
}

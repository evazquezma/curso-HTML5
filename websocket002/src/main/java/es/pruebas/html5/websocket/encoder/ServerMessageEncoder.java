package es.pruebas.html5.websocket.encoder;



import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import org.codehaus.jackson.map.ObjectMapper;

import es.pruebas.html5.websocket.message.ServerMessage;


public class ServerMessageEncoder implements Encoder.Text<ServerMessage> {
    @Override
    public void init(EndpointConfig ec) { }
    
    @Override
    public void destroy() { }
    
    @Override
    public String encode(ServerMessage message) throws EncodeException {
    	String encode = null;
    	
		try {
			encode = new ObjectMapper().writeValueAsString(message);
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
    			
        return encode;
    }
}

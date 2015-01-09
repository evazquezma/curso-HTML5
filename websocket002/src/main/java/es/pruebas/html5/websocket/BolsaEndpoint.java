package es.pruebas.html5.websocket;



import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.annotation.PostConstruct;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.pruebas.html5.websocket.decoder.ClientMessageDecoder;
import es.pruebas.html5.websocket.encoder.ServerMessageEncoder;
import es.pruebas.html5.websocket.message.ClientMessage;
import es.pruebas.html5.websocket.message.ServerMessage;

@ServerEndpoint(
        value = "/websocketbolsa",
        decoders = {ClientMessageDecoder.class}, 
        encoders = {ServerMessageEncoder.class}
        )

public class BolsaEndpoint {
	private static Logger logger = LoggerFactory.getLogger(BolsaEndpoint.class);
	
	private static Queue<Session> queue = new ConcurrentLinkedQueue<>();
	

	@PostConstruct
	public void setup() {
		logger.info("Instanciada clases chatEndPoint");
	}
	
	
    @OnOpen
    public void open(Session session, EndpointConfig conf) {
    	queue.add(session);
        logger.info("Conexión establecida. Id: {}" + session.getId());
    }
    
	
	@OnMessage
    public void message(final Session session, ClientMessage msg) {
		 logger.info("Recibido: {} de cliente {}", msg.toString(), session.getId());
		 logger.warn("No se hace nada con él");
		 
    }
    
	
    @OnClose
    public void closedConnection(Session session) {
    	queue.remove(session);
    	 logger.info("Conexión cerrada. Id: {}" + session.getId());
    }
    
    
    @OnError
    public void error(Session session, Throwable t) {
    	queue.remove(session);
    	logger.info("Error en la conexión ({}). Id: {}", t.toString(), session.getId());
    }
    
         
    
    
    public static void enviarMensaje(ServerMessage mensaje) {
      logger.info("Se va enviar un mensaje a {} posibles clientes", queue.size());
    	
       try {          
          for (Session session : queue) {       
        	  session.getBasicRemote().sendObject(mensaje);
        	  logger.info("Mensaje '{}' enviado.", mensaje);        	  
          }
       } catch (Exception e) {
    	   logger.error(e.toString());
       }
     }
}
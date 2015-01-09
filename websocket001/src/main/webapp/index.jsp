<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

	<script type='text/javascript' src='<c:url value="/resources/js/jquery-1.11.1.js" />'></script>	
	
</head>
<body>
	<div>
		<p id="status"></p>
		<button onclick="connect()">Conectar</button>
		<button onclick="desconectar()">Desconectar</button>
	</div>
	
	<br/>
	
	<div>
		Mensaje: <input type="text" id="mensaje">
		<br/>
		<button onclick="enviarMensaje()">Enviar</button>
	</div>
	
	<br/>
	
	<div>
		Recibidos:
		<br/>
		<textarea id="recibidos" rows="10" cols="100"></textarea>
	</div>
	
	
	<script>
		var wsocket;
		
		function connect() {
		   wsocket = new WebSocket("ws://localhost:8080/websocket/websocketchat");
		   wsocket.onopen  = onOpen;
		   wsocket.onclose = onClose;
			   
		   wsocket.onmessage = onMessage;
		}

		function onOpen() {			
			$("#status").html("Conexión establecida con éxito");		
		}

		function onClose() {			
			$("#status").html("Conexión cerrada con éxito");		
		}
			
		function onMessage(e) {	
			var mensaje = JSON.parse(e.data);
					
			$('#recibidos').append(mensaje.codigo + " - " + mensaje.mensaje + "\n"); 					  
		}

		
		function enviarMensaje(){
			var mensaje = {
					codigo : '001', 
					mensaje: $("#mensaje").val()
					};
						
			wsocket.send(JSON.stringify(mensaje));
		}


		function desconectar() {
			wsocket.close();
		}
				
	</script>


</body>
</html>
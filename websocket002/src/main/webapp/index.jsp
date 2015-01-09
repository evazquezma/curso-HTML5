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
	
	<table id="tablaMercados">
		<thead>
			<tr>
				<th>Empresa</th>
				<th>Cotización</th>
				<th>Diferencial</th>
			</tr>
		</thead>
		<tbody>
		
		</tbody>
	</table>
	<br/>

	<script>
		var wsocket;
		
		function connect() {
		   wsocket = new WebSocket("ws://localhost:8080/websocket/websocketbolsa");
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
			repintarTabla(mensaje.acciones);				  
		}
		

		function desconectar() {
			wsocket.close();
		}



		
		function forzarConsulta() {
			$.getJSON(
					"http://localhost:8080/websocket/bolsa", {}, 
					function(response) {
						if (!!response.success) {
							repintarTabla(response.data);							
						}
					}
				);
		}		
		
				
		
		
		function repintarTabla(data) {
			var tablaMercados = $("#tablaMercados");
			
			//Borrar los registros que hubiera, excepto la cabecera
			tablaMercados.find("tr:gt(0)").remove();
			
			for (var i=0; i < data.length; i ++) {			
				var row = $('<tr/>');
				
				//Montar el texto de las celdas y se le añaden a la fila
   			 	var col1 = $('<td/>');
   			 	col1.html(data[i].empresa);
   			 	row.append(col1);

	   			var col2 = $('<td/>');
			 	col2.html(data[i].valorAccion);
			 	row.append(col2);

			 	var col3 = $('<td/>');
   			 	col3.html(data[i].variacion);
   			 	row.append(col3);

				//Añadir la fila a la tabla
   			 	tablaMercados.append(row);  			 			        			    
			}		
		} 	


		forzarConsulta();
				
	</script>


</body>
</html>
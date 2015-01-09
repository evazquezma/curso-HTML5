<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bolsa web worker</title>

<script type='text/javascript' src='<c:url value="/resources/js/jquery-1.11.1.js" />'></script>	
<script type='text/javascript' src='<c:url value="/resources/js/modernizr.custom.40842.js" />'></script>	

</head>
<body>	
	<button onclick="startWorker()">Start Worker</button>
	<button onclick="stopWorker()">Stop Worker</button>
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
		var worker;

		function startWorker() {
			if (! Modernizr.webworkers) {
				$("#result").html("Sorry! No Web Worker support.");			
				return;
			}
			
			//Workers soportados por el navegador
						
			if (typeof (worker) === "undefined") {
				worker = new Worker("http://localhost:8080/webWorker/resources/js/task/task.js");
			}
					
			worker.addEventListener('message', function(e) {
				procesarMensaje(e.data);
			}, false);


			worker.postMessage("http://localhost:8080/webWorker/bolsa");																													
		}
		
				
		function stopWorker() {
			if (typeof (worker) !== "undefined") {
				worker.terminate();
			}
			worker = undefined;
		}
		
		
		function procesarMensaje(data) {
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
	</script>


</body>
</html>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Eemplo básico con ajax</title>
	<script type='text/javascript' src='<c:url value="/resources/js/jquery-1.11.1.js" />'></script>	
</head>
<body>

	<button name="prueba" value="ajax" onclick="realizarConsultaAJAX()">Consulta AJAX</button>
		
	<div id="ajaxRes">
		<p>Respuesta por ajax</p>
		Numero: <span id="ajaxNumero"></span> <br/>
		Fecha: <span id="ajaxDate"></span>
	</div>
	
	
	<hr/>
		
	
	<button name="prueba" value="jquery" onclick="realizarConsultaJQuery()">Consulta JQuery</button>
	<div id="jqueryRes">
		<p>Respuesta por ajax</p>
		Numero: <span id="jqueryNumero"></span> <br/>
		Fecha: <span id="jqueryDate"></span>
	</div>
	

	<script>
		/* Método tradicional directamente por ajax */
		function realizarConsultaAJAX() {
			var xmlhttp;
			if (window.XMLHttpRequest) {
				// code for IE7+, Firefox, Chrome, Opera, Safari
				xmlhttp = new XMLHttpRequest();
			} else {
				// code for IE6, IE5
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {					
					var info = JSON.parse(xmlhttp.responseText);
					
					document.getElementById("ajaxNumero").innerHTML = info.numero;
					document.getElementById("ajaxDate").innerHTML = new Date(info.fecha).toDateString();																		
				}
			}
			
			xmlhttp.open("GET", "http://localhost:8080/ajaxmvc/info", true);
			xmlhttp.send(null);			
		}
		
		
		
		/* Método predefinido encapsulando la llamada en jquery */
		function realizarConsultaJQuery() {
			$.getJSON( "http://localhost:8080/ajaxmvc/info", function(data) {
				$("#jqueryNumero").html(data.numero);
				$("#jqueryDate").html(new Date(data.fecha).toDateString());					 				 			
			});	
		}
				
	</script>
	
</body>
</html>
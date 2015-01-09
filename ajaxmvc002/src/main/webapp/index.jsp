<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script type='text/javascript' src='<c:url value="/resources/js/jquery-1.11.1.js" />'></script>	
</head>
</head>
<body>
	<h1>Cargar dinámicamente combos enlazados</h1>
	
	<div>
		Comunidadad autónoma: 
		<select id="cmbComunidad" onchange="cargarComboProvincia($(this).val())">
		</select>
	</div>
	
	<br/>
	
	<div>
		Provincia: 
		<select id="cmbProvincia">
		</select>
	</div>
	

	<script type="text/javascript">
		$(document).ready(function() {
			cargarComboComunidad();
			$( "#cmbComunidad" ).trigger( "change" )
		});
		
		
		function cargarComboComunidad() {
			$.getJSON("http://localhost:8080/ajaxmvc/geo/comunidades", function(response) {
				if (!!response.success) {
					cargarCombo(response.data, "cmbComunidad");
				}
				else {
					clearCombo("cmbComunidad");
				}
			});
		}
		
		
		function cargarComboProvincia(comunidadSel) {			
			$.getJSON(
				"http://localhost:8080/ajaxmvc/geo/provincias", 
				{
					idComunidad : comunidadSel
				},
				function(response) {
					if (!!response.success) {
						cargarCombo(response.data, "cmbProvincia");
					}
					else {
						clearCombo("cmbProvincia");
					}
				}
			);
		};
		
		
		/* A partir de la lista de elementos, crea las option del combo */			
		function cargarCombo(data, idCombo) {			
			clearCombo(idCombo);
			
			var combo = $("#"+idCombo);							
			for (var i=0; i< data.length; i++) {
				combo.append($("<option />").val(data[i].id).text(data[i].nombre));
			} 										
		}
		
		
		/* Limpia las option del combo y le pone un 'Seleccione' */
		function clearCombo(idCombo) {
			var combo = $("#"+idCombo);			
			combo.empty();
			combo.append($("<option />").val("").text("Seleccione"));
		}					
	</script>


</body>
</html>
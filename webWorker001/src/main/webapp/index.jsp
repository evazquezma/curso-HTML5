<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejemplo básico de web workers</title>

<script type='text/javascript' src='<c:url value="/resources/js/modernizr.custom.40842.js" />'></script>


</head>
<body>

	<p>
		Count numbers:
		<output id="result"></output>
	</p>
	<button onclick="startWorker()">Start Worker</button>
	<button onclick="stopWorker()">Stop Worker</button>
	<button onclick="reiniciarContador()">Reiniciar contador</button>
	<button onclick="duplicarContador()">Duplicar contador</button>
	<br>
	<br>

	<script>
		var worker;

		function startWorker() {
			if (Modernizr.webworkers) {
				
				if (typeof (worker) === "undefined") {
					worker = new Worker("http://localhost:8080/webWorker/resources/js/task/task.js");
				}
				
				worker.addEventListener('message', function(e) {
					procesarMensaje(e.data);
				}, false);											
			}			
			else {
				document.getElementById("result").innerHTML = "Sorry! No Web Worker support.";
			}							
		}
				
		function stopWorker() {
			if (typeof (worker) !== "undefined") {
				worker.terminate();
			}
			worker = undefined;
		}

		function reiniciarContador () {
			worker.postMessage({command : 'restart'})
		}

		function duplicarContador () {
			worker.postMessage({command : 'duplicar'})
		}

		
		
		function procesarMensaje(data) {
			document.getElementById("result").innerHTML = data.valor;
		} 			
	</script>


</body>
</html>
var urlBolsa=null;


function consultarMercados() {
	var xmlhttp;
	xmlhttp = new XMLHttpRequest();
	
	xmlhttp.open("GET", urlBolsa, false);
	xmlhttp.send(null);	
	
	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {					
		var response = JSON.parse(xmlhttp.responseText);
		if (!!response.success) {
			//Avisar al padre de que ha llegado nueva información
			self.postMessage(response.data);
		}
	}
	
	setTimeout("consultarMercados()", 2000);
}



//Se recibe mediante un mensaje la url de consulta de la bolsa y se comienza la ejecución
self.addEventListener('message', function(e) {
	console.log("establecida url del a bolsa a '" + e.data + "'");
	urlBolsa = e.data;
	consultarMercados(e.data);
	
}, false);	
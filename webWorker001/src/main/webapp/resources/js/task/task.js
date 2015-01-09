var i = 0;

function timedCount() {
	i = i + 1;
	 
	var mensaje = {};
	mensaje.valor = i;
   
    postMessage(mensaje);
    setTimeout("timedCount()",500);
}



self.addEventListener('message', function(e) {	
	console.log(e.data.command);
	//En javascript sólo hay un hilo de ejecución y no se interrupen las funciones, 
	//con lo que no habrá problemas por restear aquí la variable 
	if (e.data.command === "restart") {
		i = 0;
	}
	else if (e.data.command === "duplicar") {
		i = i * 2;
	}
	
}, false);	


timedCount();


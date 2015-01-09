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
	//En javascript s�lo hay un hilo de ejecuci�n y no se interrupen las funciones, 
	//con lo que no habr� problemas por restear aqu� la variable 
	if (e.data.command === "restart") {
		i = 0;
	}
	else if (e.data.command === "duplicar") {
		i = i * 2;
	}
	
}, false);	


timedCount();


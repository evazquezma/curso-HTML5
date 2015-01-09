var LENGTH_HTTP = 7;

function inspeccionarEnlaces() {
	//También se podría usar document.links, pero podría devolver enlaces dentro de <area>
	var enlaces = document.getElementsByTagName('a');
	
	for(var i = 0; i < enlaces.length; i++) {
		if (enlaceApuntaAPaginaInterna(enlaces[i]) && ! esEnlaceDeTipo('_self', enlaces[i])) {
			establecerTipoEnlace('_self', enlaces[i]);
		}
		else if (! enlaceApuntaAPaginaInterna(enlaces[i]) && ! esEnlaceDeTipo('_blank', enlaces[i])) {
			establecerTipoEnlace('_blank', enlaces[i]);
		}
		
		
		if (esEnlaceDeTipo('_blank', enlaces[i])) {
			anhadirIconoNuevaVentana(enlaces[i]);
		}
	}
} 


/* Determina si el enlace de un a es interno */
function enlaceApuntaAPaginaInterna(a) {
	var bApuntaInterna = true;
	
	var link = a.getAttribute("href");	
	if (link !== null && link.length >= LENGTH_HTTP) {		
		if (link.substr(0, LENGTH_HTTP).toLowerCase() == "http://") {
			bApuntaInterna = false;
		}
	}	
	return bApuntaInterna;
}


function esEnlaceDeTipo(tipo, a) {
	var target = a.getAttribute("target");
	if (target !== null && target === tipo) {
		return true;
	} 
	else {
		return false;
	}
}

function establecerTipoEnlace(tipo, a) {	
	a.setAttribute("target", tipo);
}

function anhadirIconoNuevaVentana (a) {
	var img = ' <img class="ventaNova" alt="nova venta" src="icono_nueva_ventana.png">';		
	a.innerHTML = a.innerHTML + img;
}
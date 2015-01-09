function addElemento(idTabla, idContador) {
	var tabla = document.getElementById(idTabla);

	var x = tabla.rows.length;
	var row = tabla.insertRow(x);
	
	//También se puede decir directamente que la añada al final de la tabla
	//var row = tabla.insertRow(-1);

	var cell1 = row.insertCell(0);
	var cell2 = row.insertCell(1);
	var cell3 = row.insertCell(2);
	
	// Añadir el contenido a las celdas. Se puede añadir directamente como HTML o como un elemento
	cell1.innerHTML = getHtmlInputCol1();
	cell2.innerHTML = getHtmlCheckCol2();
	cell3.appendChild(getButtonCol3(idContador));
	
	//Actualizar el contador de filas
	actualizarContador(tabla, idContador);
}



function getHtmlInputCol1() {
	var html = '<input type="text" name="clave"/>';
	return html;
}

function getHtmlCheckCol2() {
	var html = '<input type="checkbox" name="marcado"/>';
	return html;
}

function getButtonCol3(idContador) {
	var btn = document.createElement("BUTTON");
	var texto = document.createTextNode("-");
	btn.addEventListener("click", function (){ borrarFilaEvent(btn, idContador); });
	btn.appendChild(texto); 
	
	return btn;
}



function borrarFilaEvent(btn, idContador) {
	//var btn = this;
	var tr = btn.parentNode.parentNode;
	var tabla = tr.parentNode.parentNode;
	
	//Recuperar el padre del tr (la tabla o tableBody) y borrarlo
	tr.parentNode.removeChild(tr);
	
	actualizarContador(tabla, idContador);
}



function actualizarContador(tabla, idContador) {
	var total = tabla.rows.length;
	
	document.getElementById(idContador).innerHTML = "Hay " + (total -1 ) + " elementos";
}
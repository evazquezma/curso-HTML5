<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%@ taglib prefix="spring" 	uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form"   	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c"      	uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="${pageContext.response.locale}" lang="${pageContext.response.locale}">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>Gestión del mercado de valores</title>
</head>
<body>
	<h1>Gestión del mercado de valores</h1>
	
	<form:form modelAttribute="accionForm">
		Empresa: <form:input path="accionBean.empresa"/>
		<br/>
		Valor accion: <form:input path="accionBean.valorAccion" />
		<br/>
		Variacion : <form:input path="accionBean.variacion" />
		<br/>
		
		<form:button name="accion" value="actualizar">Actualizar</form:button>			
	</form:form>
	
	<br/>
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
			<c:forEach items="${accionesBolsa}" var="accionBolsa">
				<tr>
					<td>${accionBolsa.empresa}</td>
					<td>${accionBolsa.valorAccion}</td>
					<td>${accionBolsa.variacion}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>
<%-- 
    Document   : frmCliente
    Created on : 8 jun. 2022, 12:39:54
    Author     : Gualbert
--%>
<%
    if(session.getAttribute("logueado")!= "ok"){
        response.sendRedirect("login.jsp");
    }
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>You Tech</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"/>
    </head>
    <body>
        <div class="container">
            <h1>Formulario de Clientes</h1>

            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="clientes"/>
            </jsp:include>

            <p></p>

            <form action="ClienteControlador" method="POST">
                <input type="hidden" name="id" value="${cliente.id}" />
                <div class="mb-3">
                    <label for="nombre" class="form-label" name="nombre"  >Nombre:</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" value="${cliente.nombre}">
                    <div id="nombre" class="form-text">Escriba el Nombre</div>
                </div>
                <div class="mb-3">
                    <label  class="form-label" name="correo"  >NIT/CI:</label>
                    <input type="text" class="form-control" id="nit" name="nit" value="${cliente.nit}">
                    <div id="nit" class="form-text">Escriba el NIT/CI</div>
                </div>
                <div class="mb-3">
                    <label for="telefono" class="form-label" name="telefono"  >Telefono</label>
                    <input type="text" class="form-control" id="telefono" name="telefono" value="${cliente.telefono}">
                    <div id="telefono" class="form-text">Escriba el Telefono</div>
                </div>
                <div class="mb-3">
                    <label for="celular" class="form-label" name="celular"  >Celular</label>
                    <input type="text" class="form-control" id="nombre" name="celular" value="${cliente.celular}">
                    <div id="celular" class="form-text">Escriba el celular</div>
                </div>
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>


        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>



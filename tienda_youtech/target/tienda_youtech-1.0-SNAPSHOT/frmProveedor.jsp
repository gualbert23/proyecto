<%-- 
    Document   : frmProveedor
    Created on : 8 jun. 2022, 13:27:54
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
            <h1>Formulario de Proveedores</h1>

            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="proveedores"/>
            </jsp:include>

            <p></p>

            <form action="ProveedorControlador" method="POST">
                <input type="hidden" name="id" value="${proveedor.id}" />
                    <div class="mb-3">
                        <label for="empresa" class="form-label" name="empresa"  >Empresa:</label>
                        <input type="text" class="form-control" id="empresa" name="empresa" value="${proveedor.empresa}">
                        <div id="empresa" class="form-text">Escriba la Empresa del proveedor</div>
                    </div>
                        <div class="mb-3">
                        <label for="nit" class="form-label" name="nit"  >NIT:</label>
                        <input type="text" class="form-control" id="nit" name="nit" value="${proveedor.nit}">
                        <div id="nit" class="form-text">Escriba el NIT del proveedor</div>
                    </div>
                    <div class="mb-3">
                        <label  class="form-label" name="telefono"  >Telefono:</label>
                        <input type="text" class="form-control" name="telefono" value="${proveedor.telefono}">
                        <div  class="form-text">Escriba Telefono del proveedor</div>
                    </div>
                        <div class="mb-3">
                        <label for="direccion" class="form-label" name="direccion"  >Direccion:</label>
                        <input type="text" class="form-control" id="direccion" name="direccion" value="${proveedor.direccion}">
                        <div id="direccion" class="form-text">Escriba la direccion del proveedor</div>
                    </div>
                    <div class="mb-3">
                        <label  class="form-label" name="encargado"  >Nombre Encargado:</label>
                        <input type="text" class="form-control" name="encargado" value="${proveedor.encargado}">
                        <div  class="form-text">Escriba el nombre completo del Encargado del proveedor</div>
                    </div>
                    <div class="mb-3">
                        <label  class="form-label" name="ci"  >CI Encargado:</label>
                        <input type="text" class="form-control" name="ci" value="${proveedor.ci}">
                        <div  class="form-text">Escriba CI del Encargado del proveedor</div>
                    </div>
                        
                    <div class="mb-3">
                        <label class="form-label" name="celular"  >Celular Encargado</label>
                        <input type="text" class="form-control"  name="celular" value="${proveedor.celular}">
                        <div  class="form-text">Escriba el Celular del encargado del proveedor</div>
                    </div>
                    <button type="submit" class="btn btn-primary">Enviar</button>
                </form>
            

        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>

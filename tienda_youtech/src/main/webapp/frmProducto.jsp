<%-- 
    Document   : frmProducto
    Created on : 8 jun. 2022, 13:00:05
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
            <h1>Formulario de Productos</h1>

            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="productos"/>
            </jsp:include>

            <p></p>

            <form action="ProductoControlador" method="POST" enctype="multipart/form-data">
                <input type="hidden" name="id" value="${producto.id}" />
                    <div class="mb-3">
                        <label for="codigo" class="form-label" name="codigo"  >Codigo:</label>
                        <input type="text" class="form-control" id="codigo" name="codigo" value="${producto.codigo}">
                        <div id="codigo" class="form-text">Escriba el Codigo del producto</div>
                    </div>
                        <div class="mb-3">
                        <label for="marca" class="form-label" name="marca"  >Marca:</label>
                        <input type="text" class="form-control" id="codigo" name="marca" value="${producto.marca}">
                        <div id="marca" class="form-text">Escriba la Marca del producto</div>
                    </div>
                    <div class="mb-3">
                        <label  class="form-label" name="linea"  >Linea:</label>
                        <input type="text" class="form-control" name="linea" value="${producto.linea}">
                        <div  class="form-text">Escriba Linea del producto</div>
                    </div>
                        <div class="mb-3">
                        <label for="categoria" class="form-label" name="categoria"  >Categoria:</label>
                        <input type="text" class="form-control" id="categoria" name="categoria" value="${producto.categoria}">
                        <div id="categoria" class="form-text">Escriba la Categoria del producto</div>
                    </div>
                    <div class="mb-3">
                        <label  class="form-label" name="producto"  >Nombre del Producto:</label>
                        <input type="text" class="form-control" name="producto" value="${producto.producto}">
                        <div  class="form-text">Escriba la descripcion del producto</div>
                    </div>
                    <div class="mb-3">
                        <label  class="form-label" name="descripcion"  >Descripcion:</label>
                        <input type="textarea" class="form-control" name="descripcion" value="${producto.descripcion}">
                        <div  class="form-text">Escriba la descripcion del producto</div>
                    </div>
                        
                    <div class="mb-3">
                        <label class="form-label" name="imagen"  >Imagen</label>
                        <input type="file" class="form-control"  name="imagen" value="${producto.imagen}">
                        <div  class="form-text">imagen del producto</div>
                    </div>
                    <button type="submit" class="btn btn-primary">Enviar</button>
                </form>
            

        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>




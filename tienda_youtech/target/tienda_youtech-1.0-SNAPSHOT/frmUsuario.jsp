<%-- 
    Document   : frmUsuario
    Created on : 8 jun. 2022, 14:01:16
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
            <h1>Formulario de Usuarios</h1>

            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="usuarios"/>
            </jsp:include>

            <p></p>

            <form action="UsuarioControlador" method="POST" enctype="multipart/form-data">
                <input type="hidden" name="id" value="${usuario.id}" />
                    <div class="mb-3">
                        <label for="nombre" class="form-label" name="nombre"  >Nombres:</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" value="${usuario.nombre}">
                        <div id="nombre" class="form-text">Escriba sus Nombres</div>
                    </div>
                        <div class="mb-3">
                        <label for="apellido" class="form-label" name="apellido"  >Apellidos:</label>
                        <input type="text" class="form-control" id="apellido" name="apellido" value="${usuario.apellido}">
                        <div id="apellido" class="form-text">Escriba sus Apellidos</div>
                    </div>
                    <div class="mb-3">
                        <label  class="form-label" name="ci"  >CI:</label>
                        <input type="text" class="form-control" name="ci" value="${usuario.ci}">
                        <div  class="form-text">Escriba su Carnet de Identidad</div>
                    </div>
                        <div class="mb-3">
                        <label for="telefono" class="form-label" name="telefono"  >Telefono:</label>
                        <input type="text" class="form-control" id="telefono" name="telefono" value="${usuario.telefono}">
                        <div id="telefono" class="form-text">Escriba su telefono - celular</div>
                    </div>
                    <div class="mb-3">
                        <label  class="form-label" name="correo"  >Correo:</label>
                        <input type="email" class="form-control" name="correo" value="${usuario.correo}">
                        <div  class="form-text">Escriba su correo electronico</div>
                    </div>
                    <div class="mb-3">
                        <label  class="form-label" name="password"  >Password:</label>
                        <input type="password" class="form-control" name="password" value="${usuario.password}">
                        <div  class="form-text">Escriba su clave </div>
                    </div>
                    <div class="mb-3">
                        <label  class="form-label" name="foto"  >Foto:</label>
                        <input type="file" class="form-control" name="foto" value="${usuario.foto}">
                        <div  class="form-text">Selecione su Foto </div>
                    </div>
                        
                    <div class="mb-3">
                        <label class="form-label" name="rol"  >Rol</label>
                        <input type="text" class="form-control"  name="rol" value="${usuario.rol}">
                        <div  class="form-text">Escriba el Rol de usuario</div>
                    </div>
                    <button type="submit" class="btn btn-primary">Enviar</button>
                </form>
            

        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>


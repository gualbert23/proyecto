<%-- 
    Document   : frmDetalle_Venta
    Created on : 12 jun. 2022, 19:38:06
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
         <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="detalleVentas"/>
            </jsp:include>
        <br>
        <div class="container">
            <h1>Formulario de Detalle-Ventas</h1>

           

            <p></p>

            <form action="Detalle_VentaControlador" method="POST">
                <input type="hidden" name="id" value="${detalleVenta.id}" />
                <div class="mb-3">
                    <label  class="form-label" name="id_producto"  >Codigo del Producto:</label>
                    <select name="id_producto" class="form-control"> 
                        <option value="">--Seleccione</option>

                        <c:forEach var="item" items="${lista_productos}">
                            <option value="${item.id}" 
                                    <c:if test="${inventario.id_producto==item.id}"> 
                                selected
                                </c:if> 
                                >  ${item.codigo}
                            </option>
                        </c:forEach>
                    </select>
                    <div  class="form-text">Selecione el Codigo del producto</div>
                </div>

                <div class="mb-3">
                    <label class="form-label" name="entrada"  >Entrada</label>
                    <input type="number" class="form-control" name="entrada" value="${inventario.entrada}">
                    <div class="form-text">Escriba la cantidad de entrada del producto </div>
                </div>
                <div class="mb-3">
                    <label class="form-label" name="salida"  >Salida</label>
                    <input type="number" class="form-control" name="salida" value="${inventario.salida}">
                    <div class="form-text">Escriba la cantidad de salida del producto </div>
                </div>
                <div class="mb-3">
                    <label class="form-label" name="stock"  >Stock</label>
                    <input type="number" class="form-control" name="stock" value="${inventario.stock}">
                    <div class="form-text">Escriba el Stock del producto </div>
                </div>
                <div class="mb-3">
                    <label class="form-label" name="precio_venta"  >Precio de Venta</label>
                    <input type="text" class="form-control" name="precio_venta" value="${inventario.precio_venta}">
                    <div class="form-text">Seleccione la fecha </div>
                </div>
                <div class="mb-3">
                    <label class="form-label" name="precio_compra"  >Precio de Compra</label>
                    <input type="text" class="form-control" name="precio_compra" value="${inventario.precio_compra}">
                    <div class="form-text">Escriba el precio de compra del producto </div>
                </div>  
                <div class="mb-3">
                    <label class="form-label" name="ubicacion"  >Ubicacion</label>
                    <input type="text" class="form-control" name="ubicacion" value="${inventario.ubicacion}">
                    <div class="form-text">Escriba la Ubicacion </div>
                </div>  
                    
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>


        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>

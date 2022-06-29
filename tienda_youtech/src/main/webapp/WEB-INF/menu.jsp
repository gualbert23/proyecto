
<%
    String opcion = request.getParameter("opcion");
%>
<header>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <div class="container-fluid">
      <img src="img/youtech.png" alt="mdo" width="45" height="45" class="rounded-circle">  
      <a class="navbar-brand" href="index.jsp"> You Tech</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav me-auto mb-2 mb-md-0">
          <li class="nav-item">
            <a class="nav-link <%=(opcion.equals("clientes")?"active":"")%>" aria-current="page" href="ClienteControlador">Clientes</a>
          </li>
          <li class="nav-item">
            <a class="nav-link <%=(opcion.equals("productos")?"active":"")%>" href="ProductoControlador">Productos</a>
          </li>
          <li class="nav-item">
            <a class="nav-link <%=(opcion.equals("proveedores")?"active":"")%>" href="ProveedorControlador" tabindex="-1" aria-disabled="true">Proveedores</a>
          </li>
          <li class="nav-item">
            <a class="nav-link <%=(opcion.equals("usuarios")?"active":"")%>" href="UsuarioControlador" tabindex="-1" aria-disabled="true">Usuarios</a>
          </li>
          <li class="nav-item">
            <a class="nav-link <%=(opcion.equals("inventarios")?"active":"")%>" href="InventarioControlador" tabindex="-1" aria-disabled="true">Inventario</a>
          </li>
          <li class="nav-item">
            <a class="nav-link <%=(opcion.equals("detalleVentas")?"active":"")%>" href="Detalle_VentaControlador" tabindex="-1" aria-disabled="true">Detalle-Ventas</a>
          </li>
          <li class="nav-item">
            <a class="nav-link <%=(opcion.equals("ventas")?"active":"")%>" href="VentaControlador" tabindex="-1" aria-disabled="true">Ventas</a>
          </li>
        </ul>
          
            <p class="navbar-brand">Bienvenido: <%=session.getAttribute("usuario") %></p>
          <div class="dropdown text-end">
              
          <a href="#" class="d-block link-white text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
            <img src="<%=session.getAttribute("foto") %>" alt="mdo" width="45" height="45" class="rounded-circle">
          </a>
          <ul class="dropdown-menu text-small" aria-labelledby="dropdownUser1">
            
            <li><a class="dropdown-item" href="#">Perfil</a></li>
            <li><a class="dropdown-item" href="#">Configurar</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="LoginControlador?action=logout">Cerrar Sesion</a></li>
          </ul>
        </div>
        <form class="d-flex">
            <a href="LoginControlador?action=logout" class="btn btn-outline-danger">Cerrar Sesion</a>
        
        </form>
          
          
          
      </div>
    </div>
  </nav>
</header>

          <br>
          <br>
          

    
    
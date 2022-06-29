
package com.emergentes.controlador;

import com.emergentes.dao.Detalle_VentaDAO;
import com.emergentes.dao.Detalle_VentaDAOimpl;
import com.emergentes.dao.InventarioDAO;
import com.emergentes.dao.InventarioDAOimpl;
import com.emergentes.dao.ProductoDAO;
import com.emergentes.dao.ProductoDAOimpl;
import com.emergentes.modelo.Detalle_Venta;
import com.emergentes.modelo.Inventario;
import com.emergentes.modelo.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gualbert
 */
@WebServlet(name = "Detalle_VentaControlador", urlPatterns = {"/Detalle_VentaControlador"})
public class Detalle_VentaControlador extends HttpServlet {

   
    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {

            Detalle_VentaDAO dao = new Detalle_VentaDAOimpl();
            ProductoDAO daoProducto = new ProductoDAOimpl();
            InventarioDAO daoInventario = new InventarioDAOimpl();
            int id;
            List<Producto> lista_productos = null;
            List<Inventario> lista_inventario = null;
            Detalle_Venta dv = new Detalle_Venta();

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    //llenar la lista de prodcutos
                    lista_productos=daoProducto.getAll();
                    lista_inventario=daoInventario.getAll();
                    request.setAttribute("lista_productos", lista_productos);
                    request.setAttribute("lista_inventario", lista_inventario);
                    
                    request.setAttribute("detalleVenta", dv);
                    request.getRequestDispatcher("frmDetalle_Venta.jsp").forward(request, response);
                    break;

                case "edit":
                    //
                    lista_productos=daoProducto.getAll();
                    lista_inventario=daoInventario.getAll();
                    request.setAttribute("lista_productos", lista_productos);
                    request.setAttribute("lista_inventario", lista_inventario);
                    
                    id = Integer.parseInt(request.getParameter("id"));
                    dv = dao.getById(id);
                    request.setAttribute("detalleVenta", dv);
                    request.getRequestDispatcher("frmDetalle_Venta.jsp").forward(request, response);
                    break;

                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("Detalle_VentaControlador");
                    break;

                case "view":
                    //obtener la lista de registros(objetos)
                    List<Detalle_Venta> lista = dao.getAll();
                    request.setAttribute("detalleVentas", lista);
                    request.getRequestDispatcher("detalleVentas.jsp").forward(request, response);
                    break;
            }

        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
    }

    

}

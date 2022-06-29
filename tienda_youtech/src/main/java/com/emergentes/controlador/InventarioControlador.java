
package com.emergentes.controlador;

import com.emergentes.dao.InventarioDAO;
import com.emergentes.dao.InventarioDAOimpl;
import com.emergentes.dao.ProductoDAO;
import com.emergentes.dao.ProductoDAOimpl;
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
@WebServlet(name = "InventarioControlador", urlPatterns = {"/InventarioControlador"})
public class InventarioControlador extends HttpServlet {

    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            InventarioDAO dao = new InventarioDAOimpl();
            ProductoDAO daoProducto = new ProductoDAOimpl();
            
            int id;
            List<Producto> lista_productos = null;
            Inventario i = new Inventario();

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    //lenar la lista de prodcutos
                    lista_productos=daoProducto.getAll();
                    
                    request.setAttribute("lista_productos", lista_productos);
                                        
                    request.setAttribute("inventario", i);
                    request.getRequestDispatcher("frmInventario.jsp").forward(request, response);
                    break;

                case "edit":
                    //
                    lista_productos=daoProducto.getAll();
                    
                    request.setAttribute("lista_productos", lista_productos);
                                        
                    id = Integer.parseInt(request.getParameter("id"));
                    i = dao.getById(id);
                    request.setAttribute("inventario", i);
                    request.getRequestDispatcher("frmInventario.jsp").forward(request, response);
                    break;

                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("InventarioControlador");
                    break;

                case "view":
                    //obtener la lista de registros(objetos)
                    List<Inventario> lista = dao.getAll();
                    request.setAttribute("inventarios", lista);
                    request.getRequestDispatcher("inventario.jsp").forward(request, response);
                    break;
            }

        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
        
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        int id_producto=Integer.parseInt(request.getParameter("id_producto"));
        int entrada=Integer.parseInt(request.getParameter("entrada"));
        int salida=Integer.parseInt(request.getParameter("salida"));
        int stock=Integer.parseInt(request.getParameter("stock"));
        
        float precio_venta=Float.parseFloat(request.getParameter("precio_venta"));
        float precio_compra=Float.parseFloat(request.getParameter("precio_compra"));
        String ubicacion=request.getParameter("ubicacion");
       
        Inventario inv = new Inventario();
        inv.setId(id);
        inv.setId_producto(id_producto);
        inv.setEntrada(entrada);
        inv.setSalida(salida);
        inv.setStock(entrada-salida);
        inv.setPrecio_venta(precio_venta);
        inv.setPrecio_compra(precio_compra);
        inv.setUbicacion(ubicacion);
        
        
        InventarioDAO dao = new InventarioDAOimpl();
        
        if(id==0){
            try {
                //nuevo registro

                dao.insert(inv);
            } catch (Exception ex) {
                System.out.println("Error al Insertar inventario."+ex.getMessage());            }
        }else{
            try {
                //edicion de registro
                dao.update(inv);
            } catch (Exception ex) {
                System.out.println("Error al EDITAR inventario."+ex.getMessage());            }
        }
        response.sendRedirect("InventarioControlador");
        
    }

    
    

}

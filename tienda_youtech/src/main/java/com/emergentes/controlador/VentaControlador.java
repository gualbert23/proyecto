
package com.emergentes.controlador;

import com.emergentes.dao.VentaDAO;
import com.emergentes.dao.VentaDAOimpl;
import com.emergentes.modelo.Venta;
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
@WebServlet(name = "VentaControlador", urlPatterns = {"/VentaControlador"})
public class VentaControlador extends HttpServlet {

    
    

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            Venta ven = new Venta();
            int id;
            VentaDAO dao = new VentaDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("venta", ven);
                    request.getRequestDispatcher("frmVenta.jsp").forward(request, response);
                break;
                
                case "edit":
                    id=Integer.parseInt(request.getParameter("id"));
                    ven = dao.getById(id);
                     request.setAttribute("venta", ven);
                    request.getRequestDispatcher("frmVenta.jsp").forward(request, response);
                break;
                
                case "delete":
                    id=Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("VentaControlador");
                break;
                
                case "view":
                    //obtener la lista de registros(objetos)
                    List <Venta> lista = dao.getAll();
                    request.setAttribute("ventas", lista);
                    request.getRequestDispatcher("ventas.jsp").forward(request, response);
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
        int id_cliente=Integer.parseInt(request.getParameter("id_cliente"));
        int id_usuario=Integer.parseInt(request.getParameter("id_usuario"));
        float precioTotal=Float.parseFloat(request.getParameter("precioTotal"));
        String tipoDocumento=request.getParameter("tipoDocumento");
        String numero=request.getParameter("numero");
        String fecha=request.getParameter("fecha");
        
        
        Venta ven = new Venta();
        ven.setId(id);
        ven.setId_cliente(id_cliente);
        ven.setId_usuario(id_usuario);
        ven.setPrecioTotal(precioTotal);
        ven.setTipoDocumento(tipoDocumento);
        ven.setNumero(numero);
        ven.setFecha(fecha);
        
        
        VentaDAO dao = new VentaDAOimpl();
        if(id==0){
            try {
                //nuevo registro

                dao.insert(ven);
            } catch (Exception ex) {
                System.out.println("Error al Insertar."+ex.getMessage());            }
        }else{
            try {
                //edicion de registro
                dao.update(ven);
            } catch (Exception ex) {
                System.out.println("Error al EDITAR."+ex.getMessage());            }
        }
        response.sendRedirect("VentaControlador");
        
        
    }

    

}

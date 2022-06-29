
package com.emergentes.controlador;

import com.emergentes.dao.ProveedorDAO;
import com.emergentes.dao.ProveedorDAOimpl;
import com.emergentes.modelo.Proveedor;
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
@WebServlet(name = "ProveedorControlador", urlPatterns = {"/ProveedorControlador"})
public class ProveedorControlador extends HttpServlet {

   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            Proveedor prov = new Proveedor();
            int id;
            ProveedorDAO dao = new ProveedorDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("proveedor", prov);
                    request.getRequestDispatcher("frmProveedor.jsp").forward(request, response);
                break;
                
                case "edit":
                    id=Integer.parseInt(request.getParameter("id"));
                    prov = dao.getById(id);
                     request.setAttribute("proveedor", prov);
                    request.getRequestDispatcher("frmProveedor.jsp").forward(request, response);
                break;
                
                case "delete":
                    id=Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("ProveedorControlador");
                break;
                
                case "view":
                    //obtener la lista de registros(objetos)
                    List <Proveedor> lista = dao.getAll();
                    request.setAttribute("proveedores", lista);
                    request.getRequestDispatcher("proveedores.jsp").forward(request, response);
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
        String empresa=request.getParameter("empresa");
        String nit=request.getParameter("nit");
        String telefono=request.getParameter("telefono");
        String direccion=request.getParameter("direccion");
        String encargado=request.getParameter("encargado");
        String ci=request.getParameter("ci");
        String celular=request.getParameter("celular");
        
       
        
        Proveedor prov = new Proveedor();
        prov.setId(id);
        prov.setEmpresa(empresa);
        prov.setNit(nit);
        prov.setTelefono(telefono);
        prov.setDireccion(direccion);
        prov.setEncargado(encargado);
        prov.setCi(ci);
        prov.setCelular(celular);
        
        ProveedorDAO dao = new ProveedorDAOimpl();
        if(id==0){
            try {
                //nuevo registro

                dao.insert(prov);
            } catch (Exception ex) {
                System.out.println("Error al Insertar."+ex.getMessage());            }
        }else{
            try {
                //edicion de registro
                dao.update(prov);
            } catch (Exception ex) {
                System.out.println("Error al EDITAR."+ex.getMessage());            }
        }
        response.sendRedirect("ProveedorControlador");
        
    }

    

}

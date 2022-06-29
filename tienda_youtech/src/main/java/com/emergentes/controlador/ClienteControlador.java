
package com.emergentes.controlador;

import com.emergentes.dao.ClienteDAO;
import com.emergentes.dao.ClienteDAOimpl;
import com.emergentes.modelo.Cliente;
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
@WebServlet(name = "ClienteControlador", urlPatterns = {"/ClienteControlador"})
public class ClienteControlador extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            Cliente cli = new Cliente();
            int id;
            ClienteDAO dao = new ClienteDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("cliente", cli);
                    request.getRequestDispatcher("frmCliente.jsp").forward(request, response);
                break;
                
                case "edit":
                    id=Integer.parseInt(request.getParameter("id"));
                    cli = dao.getById(id);
                     request.setAttribute("cliente", cli);
                    request.getRequestDispatcher("frmCliente.jsp").forward(request, response);
                break;
                
                case "delete":
                    id=Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("ClienteControlador");
                break;
                
                case "view":
                    //obtener la lista de registros(objetos)
                    List <Cliente> lista = dao.getAll();
                    request.setAttribute("clientes", lista);
                    request.getRequestDispatcher("clientes.jsp").forward(request, response);
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
        String nombre=request.getParameter("nombre");
        String nit=request.getParameter("nit");
        String telefono=request.getParameter("telefono");
        String celular=request.getParameter("celular");
        
        Cliente cli = new Cliente();
        cli.setId(id);
        cli.setNombre(nombre);
        cli.setNit(nit);
        cli.setTelefono(telefono);
        cli.setCelular(celular);
        System.out.println("HOLA");
        ClienteDAO dao = new ClienteDAOimpl();
        if(id==0){
            try {
                //nuevo registro

                dao.insert(cli);
            } catch (Exception ex) {
                System.out.println("Error al Insertar."+ex.getMessage());            }
        }else{
            try {
                //edicion de registro
                dao.update(cli);
            } catch (Exception ex) {
                System.out.println("Error al EDITAR."+ex.getMessage());            }
        }
        response.sendRedirect("ClienteControlador");
        
        
        
    }

    

}

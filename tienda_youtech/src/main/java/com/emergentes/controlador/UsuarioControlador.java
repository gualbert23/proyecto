
package com.emergentes.controlador;

import com.emergentes.dao.UsuarioDAO;
import com.emergentes.dao.UsuarioDAOimpl;
import com.emergentes.modelo.Usuario;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Gualbert
 */
@WebServlet(name = "UsuarioControlador", urlPatterns = {"/UsuarioControlador"})
public class UsuarioControlador extends HttpServlet {

    
    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        try {
            Usuario usr = new Usuario();
            int id;
            UsuarioDAO dao = new UsuarioDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("usuario", usr);
                    request.getRequestDispatcher("frmUsuario.jsp").forward(request, response);
                break;
                
                case "edit":
                    id=Integer.parseInt(request.getParameter("id"));
                    usr = dao.getById(id);
                     request.setAttribute("usuario", usr);
                    request.getRequestDispatcher("frmUsuario.jsp").forward(request, response);
                break;
                
                case "delete":
                    id=Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("UsuarioControlador");
                break;
                
                case "view":
                    //obtener la lista de registros(objetos)
                    List <Usuario> lista = dao.getAll();
                    request.setAttribute("usuarios", lista);
                    request.getRequestDispatcher("usuarios.jsp").forward(request, response);
                break;
            }

        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<String> lista = new ArrayList<>();
        FileItemFactory file = new DiskFileItemFactory();
            ServletFileUpload fileUpload = new ServletFileUpload(file);
        try {
        List items = fileUpload.parseRequest(request);
            String nombreImagen="C:\\Users\\Gualbert\\Documents\\NetBeansProjects\\tienda_youtech\\src\\main\\webapp\\imgUsuario\\";
            for (int i = 0; i < items.size(); i++) {
                FileItem fileItem = (FileItem) items.get(i);
                System.out.println(items.get(i));
                if (!fileItem.isFormField()) {
                    File f = new File(nombreImagen + lista.get(0)+ fileItem.getName());
                    fileItem.write(f);
                    nombreImagen =  "imgUsuario/"+f.getName();
                } else {
                    lista.add(fileItem.getString());
                }
            }
            System.out.println("LISTA..."+lista);
            System.out.println("NOMBRE..." + nombreImagen);
        
        int id = Integer.parseInt(lista.get(0));
        String nombre=lista.get(1);
        String apellido=lista.get(2);
        String ci=lista.get(3);
        String telefono=lista.get(4);
        String correo=lista.get(5);
        String password=lista.get(6);
        String foto=nombreImagen;
        String rol=lista.get(7);
     
        Usuario usr = new Usuario();
        usr.setId(id);
        usr.setNombre(nombre);
        usr.setApellido(apellido);
        usr.setCi(ci);
        usr.setTelefono(telefono);
        usr.setCorreo(correo);
        usr.setPassword(password);
        usr.setFoto(foto);
        usr.setRol(rol);
        
        UsuarioDAO dao = new UsuarioDAOimpl();
        if(id==0){
            try {
                //nuevo registro

                dao.insert(usr);
            } catch (Exception ex) {
                System.out.println("Error al Insertar Usuario."+ex.getMessage());            }
        }else{
            try {
                //edicion de registro
                dao.update(usr);
            } catch (Exception ex) {
                System.out.println("Error al EDITAR Usuario."+ex.getMessage());            }
        }
        response.sendRedirect("UsuarioControlador");
        
        } catch (FileUploadException ex) {
            Logger.getLogger(ProductoControlador.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al cargar Imagen.  "+ex);
        } catch (Exception ex) {
            Logger.getLogger(ProductoControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

}

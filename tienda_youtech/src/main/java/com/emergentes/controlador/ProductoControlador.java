package com.emergentes.controlador;

import com.emergentes.dao.ProductoDAO;
import com.emergentes.dao.ProductoDAOimpl;
import com.emergentes.modelo.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.Part;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Gualbert
 */
@WebServlet(name = "ProductoControlador", urlPatterns = {"/ProductoControlador"})
public class ProductoControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Producto pro = new Producto();
            int id;
            ProductoDAO dao = new ProductoDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("producto", pro);
                    request.getRequestDispatcher("frmProducto.jsp").forward(request, response);
                    break;

                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    pro = dao.getById(id);
                    request.setAttribute("producto", pro);
                    request.getRequestDispatcher("frmProducto.jsp").forward(request, response);
                    break;

                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("ProductoControlador");
                    break;

                case "view":
                    //obtener la lista de registros(objetos)
                    List<Producto> lista = dao.getAll();
                    request.setAttribute("productos", lista);
                    request.getRequestDispatcher("productos.jsp").forward(request, response);
                    break;
            }

        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ide= request.getParameter("id");
        String code= request.getParameter("codigo");
        System.out.println("IMPRIMIENDO..."+ide+"..."+code );
        ArrayList<String> lista = new ArrayList<>();
        FileItemFactory file = new DiskFileItemFactory();
            ServletFileUpload fileUpload = new ServletFileUpload(file);
        try {
            
            List items = fileUpload.parseRequest(request);
            String nombreImagen="C:\\Users\\Gualbert\\Documents\\NetBeansProjects\\tienda_youtech\\src\\main\\webapp\\imgProductos\\";
            for (int i = 0; i < items.size(); i++) {
                FileItem fileItem = (FileItem) items.get(i);
                System.out.println(items.get(i));
                if (!fileItem.isFormField()) {
                    File f = new File(nombreImagen + lista.get(0)+ fileItem.getName());
                    fileItem.write(f);
                    nombreImagen =  "imgProductos/"+f.getName();
                } else {
                    lista.add(fileItem.getString());
                }
            }
            System.out.println("LISTA..."+lista);
            System.out.println("NOMBRE..." + nombreImagen);
        
        int id = Integer.parseInt(lista.get(0));
        String codigo = request.getParameter("codigo");
        String marca = request.getParameter("marca");
        String linea = request.getParameter("linea");
        String categoria = request.getParameter("categoria");
        String producto = request.getParameter("producto");
        String descripcion = request.getParameter("descripcion");
        String imagen = request.getParameter("imagen");

        Producto pro = new Producto();
        pro.setId(Integer.parseInt(lista.get(0)));
        pro.setCodigo(lista.get(1));
        pro.setMarca(lista.get(2));
        pro.setLinea(lista.get(3));
        pro.setCategoria(lista.get(4));
        pro.setProducto(lista.get(5));
        pro.setDescripcion(lista.get(6));
        pro.setImagen(nombreImagen);

        ProductoDAO dao = new ProductoDAOimpl();
        if (id == 0) {
            try {
                //nuevo registro

                dao.insert(pro);
            } catch (Exception ex) {
                System.out.println("Error al Insertar." + ex.getMessage());
            }
        } else {
            try {
                //edicion de registro
                dao.update(pro);
            } catch (Exception ex) {
                System.out.println("Error al EDITAR." + ex.getMessage());
            }
        }
        response.sendRedirect("ProductoControlador");

        
        } catch (FileUploadException ex) {
            Logger.getLogger(ProductoControlador.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al cargar Imagen.  "+ex);
        } catch (Exception ex) {
            Logger.getLogger(ProductoControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}

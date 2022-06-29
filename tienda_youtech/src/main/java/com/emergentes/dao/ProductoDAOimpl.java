
package com.emergentes.dao;

import com.emergentes.modelo.Producto;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gualbert
 */
public class ProductoDAOimpl extends ConexionDB implements ProductoDAO{

    @Override
    public void insert(Producto producto) throws Exception {
         try {
            String sql = "insert into productos(codigo,marca,linea,categoria,producto,descripcion,imagen) values (?,?,?,?,?,?,?)";
                          
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getMarca());
            ps.setString(3, producto.getLinea());
            ps.setString(4, producto.getCategoria());
            ps.setString(5, producto.getProducto());
            ps.setString(6, producto.getDescripcion());
            ps.setString(7, producto.getImagen());
                        
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Producto producto) throws Exception {
        try {
            String sql = "update productos set codigo=?,marca=?,linea=?,categoria=?,producto=?,descripcion=?,imagen=? where id=?";
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getMarca());
            ps.setString(3, producto.getLinea());
            ps.setString(4, producto.getCategoria());
            ps.setString(5, producto.getProducto());
            ps.setString(6, producto.getDescripcion());
            ps.setString(7, producto.getImagen());
            ps.setInt(8, producto.getId());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            String sql = "delete from productos where id =?";
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Producto getById(int id) throws Exception {
        Producto prod = new Producto();
        try {
            String sql = "select * from Productos where id =?";
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                prod.setId(rs.getInt("id"));
                prod.setCodigo(rs.getString("codigo"));
                prod.setMarca(rs.getString("marca"));
                prod.setLinea(rs.getString("linea"));
                prod.setCategoria(rs.getString("categoria"));
                prod.setProducto(rs.getString("producto"));
                prod.setDescripcion(rs.getString("descripcion"));
                prod.setImagen(rs.getString("imagen"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return prod;
    }

    @Override
    public List<Producto> getAll() throws Exception {
        List<Producto> lista = null;
        try {
            String sql = "select * from productos";
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Producto>();
            while (rs.next()) {
                Producto prod = new Producto();
                prod.setId(rs.getInt("id"));
                prod.setCodigo(rs.getString("codigo"));
                prod.setMarca(rs.getString("marca"));
                prod.setLinea(rs.getString("linea"));
                prod.setCategoria(rs.getString("categoria"));
                prod.setProducto(rs.getString("producto"));
                prod.setDescripcion(rs.getString("descripcion"));
                prod.setImagen(rs.getString("imagen"));

                lista.add(prod);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }
    
}

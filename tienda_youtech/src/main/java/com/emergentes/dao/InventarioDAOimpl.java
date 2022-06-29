
package com.emergentes.dao;

import com.emergentes.modelo.Inventario;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gualbert
 */
public class InventarioDAOimpl extends ConexionDB implements InventarioDAO{

    @Override
    public void insert(Inventario inventario) throws Exception {
        try {
            String sql = "insert into inventario(id_producto,entrada,salida,stock,precio_venta,precio_compra,ubicacion) values (?,?,?,?,?,?,?)";
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, inventario.getId_producto());
            ps.setInt(2, inventario.getEntrada());
            ps.setInt(3, inventario.getSalida());
            ps.setInt(4, inventario.getStock());
            ps.setFloat(5, inventario.getPrecio_venta());
            ps.setFloat(6, inventario.getPrecio_compra());
            ps.setString(7, inventario.getUbicacion());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Inventario inventario) throws Exception {
        try {
            String sql = "update inventario set id_producto=?,entrada=?,salida=?,stock=?,precio_venta=?,precio_compra=?,ubicacion=? where id=?";
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, inventario.getId_producto());
            ps.setInt(2, inventario.getEntrada());
            ps.setInt(3, inventario.getSalida());
            ps.setInt(4, inventario.getStock());
            ps.setFloat(5, inventario.getPrecio_venta());
            ps.setFloat(6, inventario.getPrecio_compra());
            ps.setString(7, inventario.getUbicacion());
            ps.setInt(8, inventario.getId());

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
            String sql = "delete from inventario where id =?";
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
    public Inventario getById(int id) throws Exception {
         Inventario inv = new Inventario();
     
        try {
            String sql = "select * from inventario where id =?";
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                inv.setId(rs.getInt("id"));
                inv.setId_producto(rs.getInt("id_producto"));
                inv.setEntrada(rs.getInt("entrada"));
                inv.setSalida(rs.getInt("salida"));
                inv.setStock(rs.getInt("stock"));
                inv.setPrecio_venta(rs.getFloat("precio_venta"));
                inv.setPrecio_compra(rs.getFloat("precio_compra"));
                inv.setUbicacion(rs.getString("ubicacion"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return inv;
    }

    @Override
    public List<Inventario> getAll() throws Exception {
        List<Inventario> lista = null;
        try {
            String sql = "SELECT i.*,p.codigo as CODIGO, p.marca as MARCA, p.producto as NOMBRE, p.descripcion as DESCRIPCION FROM inventario i ";
            sql +="LEFT JOIN productos p ON i.id_producto = p.id";
            
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Inventario>();
            while (rs.next()) {
                Inventario inv = new Inventario();
                inv.setId(rs.getInt("id"));
                inv.setId_producto(rs.getInt("id_producto"));
                inv.setEntrada(rs.getInt("entrada"));
                inv.setSalida(rs.getInt("salida"));
                inv.setStock(rs.getInt("stock"));
                inv.setPrecio_venta(rs.getFloat("precio_venta"));
                inv.setPrecio_compra(rs.getFloat("precio_compra"));
                inv.setUbicacion(rs.getString("ubicacion"));
                
                inv.setCodigoPro(rs.getString("codigo"));
                inv.setMarcaPro(rs.getString("marca"));
                inv.setProductoPro(rs.getString("nombre"));
                inv.setDescripcionPro(rs.getString("descripcion"));
                                
                lista.add(inv);
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

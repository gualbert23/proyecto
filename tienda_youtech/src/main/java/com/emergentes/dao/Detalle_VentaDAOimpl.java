package com.emergentes.dao;

import com.emergentes.modelo.Detalle_Venta;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gualbert
 */
public class Detalle_VentaDAOimpl extends ConexionDB implements Detalle_VentaDAO {

    @Override
    public void insert(Detalle_Venta detalle_venta) throws Exception {
        try {
            String sql = "insert into detalle_venta(id_inventario,cantidad,subTotal) values (?,?,?)";

            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, detalle_venta.getId_inventario());
            ps.setInt(2, detalle_venta.getCantidad());
            ps.setFloat(3, detalle_venta.getSubTotal());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }

    }

    @Override
    public void update(Detalle_Venta detalle_venta) throws Exception {
        try {
            String sql = "update detalle_venta set id_inventario=?,cantidad=?,subTotal=? where id=?";
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, detalle_venta.getId_inventario());
            
            ps.setInt(2, detalle_venta.getCantidad());
            ps.setFloat(3, detalle_venta.getSubTotal());

            ps.setInt(4, detalle_venta.getId());

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
            String sql = "delete from detalle_venta where id =?";
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
    public Detalle_Venta getById(int id) throws Exception {
        Detalle_Venta detaVenta = new Detalle_Venta();
        try {
            String sql = "select * from detalle_venta where id =?";
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                detaVenta.setId(rs.getInt("id"));
                detaVenta.setId_inventario(rs.getInt("id_inventario"));
                
                detaVenta.setCantidad(rs.getInt("cantidad"));
                detaVenta.setSubTotal(rs.getFloat("SubTotal"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return detaVenta;

    }

    @Override
    public List<Detalle_Venta> getAll() throws Exception {
        List<Detalle_Venta> lista = null;
        try {
            String sql = "SELECT dv.*,p.codigo as CODIGO, P.marca as MARCA, p.producto AS NOMBRE, p.descripcion AS DESCRIPCION, i.stock AS STOCK, i.precio_venta AS PRECIO FROM detalle_venta dv ";
            sql +="LEFT JOIN inventario i ON dv.id_inventario = i.id ";
            sql +="LEFT JOIN productos p ON i.id_producto = p.id ";
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Detalle_Venta>();
            while (rs.next()) {
                Detalle_Venta detaVenta = new Detalle_Venta();
                detaVenta.setId(rs.getInt("id"));
                detaVenta.setId_inventario(rs.getInt("id_inventario"));
                
                detaVenta.setCantidad(rs.getInt("cantidad"));
                detaVenta.setSubTotal(rs.getFloat("subTotal"));
                
                detaVenta.setCodigoPro(rs.getString("codigo"));
                detaVenta.setMarcaPro(rs.getString("marca"));
                detaVenta.setNombrePro(rs.getString("nombre"));
                detaVenta.setDetallePro(rs.getString("descripcion"));
                
                detaVenta.setStok(rs.getInt("stock"));
                detaVenta.setPrecioVenta(rs.getFloat("precio"));
                
                lista.add(detaVenta);
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

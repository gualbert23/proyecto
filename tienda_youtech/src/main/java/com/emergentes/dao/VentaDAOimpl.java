
package com.emergentes.dao;

import com.emergentes.modelo.Venta;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gualbert
 */
public class VentaDAOimpl extends ConexionDB implements VentaDAO{

    @Override
    public void insert(Venta venta) throws Exception {
        try {
            String sql = "insert into ventas(id_cliente,id_usuario,precioTotal,tipoDocumento,numero,fecha) values (?,?,?,?,?,?)";
                          
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, venta.getId_cliente());
            ps.setInt(2, venta.getId_usuario());
            ps.setFloat(3, venta.getPrecioTotal());
            ps.setString(4, venta.getTipoDocumento());
            ps.setString(5, venta.getNumero());
            ps.setString(6, venta.getFecha());
            
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    
    }

    @Override
    public void update(Venta venta) throws Exception {
        try {
            String sql = "update ventas set id_cliente=?,id_usuario=?,precioTotal=?,tipoDocumento=?,numero=?,fecha=? where id=?";
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, venta.getId_cliente());
            ps.setInt(2, venta.getId_usuario());
            ps.setFloat(3, venta.getPrecioTotal());
            ps.setString(4, venta.getTipoDocumento());
            ps.setString(5, venta.getNumero());
            ps.setString(6, venta.getFecha());
            ps.setInt(7, venta.getId());

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
            String sql = "delete from ventas where id =?";
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
    public Venta getById(int id) throws Exception {
        Venta ven = new Venta();
        try {
            String sql = "select * from ventas where id =?";
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ven.setId(rs.getInt("id"));
                ven.setId_cliente(rs.getInt("id_cliente"));
                ven.setId_usuario(rs.getInt("id_usuario"));
                ven.setPrecioTotal(rs.getFloat("precioTotal"));
                ven.setTipoDocumento(rs.getString("tipoDocumento"));
                ven.setNumero(rs.getString("numero"));
                ven.setFecha(rs.getString("fecha"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return ven;
    }

    @Override
    public List<Venta> getAll() throws Exception {
        List<Venta> lista = null;
        try {
            //String sql ="select * from ventas";
            String sql = "SELECT v.*,c.nombre as NOMBRE, c.nit as NIT, u.nombres AS NOMBRE_USUARIO, u.apellidos AS APELLIDO_USUARIO FROM ventas v  ";
            sql +="LEFT JOIN clientes c ON v.id_cliente = c.id ";
            sql +="LEFT JOIN usuarios u ON v.id_usuario = u.id";
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Venta>();
            while (rs.next()) {
                Venta ven = new Venta();
                ven.setId(rs.getInt("id"));
                ven.setId_cliente(rs.getInt("id_cliente"));
                ven.setId_usuario(rs.getInt("id_usuario"));
                ven.setPrecioTotal(rs.getFloat("precioTotal"));
                ven.setTipoDocumento(rs.getString("tipoDocumento"));
                ven.setNumero(rs.getString("numero"));
                ven.setFecha(rs.getString("fecha"));
                
                
                ven.setNombre(rs.getString("nombre"));
                ven.setNit(rs.getString("nit"));
                ven.setNombre_usuario(rs.getString("nombre_usuario"));
                ven.setApellido_usuario(rs.getString("apellido_usuario"));
                                
                lista.add(ven);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("hola ERROR 2323" + e);
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }
    
}

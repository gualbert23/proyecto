
package com.emergentes.dao;

import com.emergentes.modelo.Proveedor;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gualbert
 */
public class ProveedorDAOimpl extends ConexionDB implements ProveedorDAO{

    @Override
    public void insert(Proveedor proveedor) throws Exception {
        try {
            String sql = "insert into proveedores(empresa,nit,telefono,direccion,encargado,ci,celular) values (?,?,?,?,?,?,?)";
                          
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, proveedor.getEmpresa());
            ps.setString(2, proveedor.getNit());
            ps.setString(3, proveedor.getTelefono());
            ps.setString(4, proveedor.getDireccion());
            ps.setString(5, proveedor.getEncargado());
            ps.setString(6, proveedor.getCi());
            ps.setString(7, proveedor.getCelular());
                        
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Proveedor proveedor) throws Exception {
        try {
            String sql = "update proveedores set empresa=?,nit=?,telefono=?,direccion=?,encargado=?,ci=?,celular=? where id=?";
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, proveedor.getEmpresa());
            ps.setString(2, proveedor.getNit());
            ps.setString(3, proveedor.getTelefono());
            ps.setString(4, proveedor.getDireccion());
            ps.setString(5, proveedor.getEncargado());
            ps.setString(6, proveedor.getCi());
            ps.setString(7, proveedor.getCelular());
            ps.setInt(8, proveedor.getId());

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
            String sql = "delete from proveedores where id =?";
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
    public Proveedor getById(int id) throws Exception {
        Proveedor prov = new Proveedor();
        try {
            String sql = "select * from Proveedores where id =?";
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                prov.setId(rs.getInt("id"));
                prov.setEmpresa(rs.getString("empresa"));
                prov.setNit(rs.getString("nit"));
                prov.setTelefono(rs.getString("telefono"));
                prov.setDireccion(rs.getString("direccion"));
                prov.setEncargado(rs.getString("encargado"));
                prov.setCi(rs.getString("ci"));
                prov.setCelular(rs.getString("celular"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return prov;
    }

    @Override
    public List<Proveedor> getAll() throws Exception {
        List<Proveedor> lista = null;
        try {
            String sql = "select * from proveedores";
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Proveedor>();
            while (rs.next()) {
                Proveedor prov = new Proveedor();
                prov.setId(rs.getInt("id"));
                prov.setEmpresa(rs.getString("empresa"));
                prov.setNit(rs.getString("nit"));
                prov.setTelefono(rs.getString("telefono"));
                prov.setDireccion(rs.getString("direccion"));
                prov.setEncargado(rs.getString("encargado"));
                prov.setCi(rs.getString("ci"));
                prov.setCelular(rs.getString("celular"));

                lista.add(prov);
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

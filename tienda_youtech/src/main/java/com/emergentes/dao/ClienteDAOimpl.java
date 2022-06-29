
package com.emergentes.dao;

import com.emergentes.modelo.Cliente;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gualbert
 */
public class ClienteDAOimpl extends ConexionDB implements ClienteDAO{

    @Override
    public void insert(Cliente cliente) throws Exception {
         try {
            String sql = "insert into clientes(nombre,nit,telefono,celular) values (?,?,?,?)";
                          
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getNit());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getCelular());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Cliente cliente) throws Exception {
        try {
            String sql = "update clientes set nombre=?,nit=?,telefono=?,celular=? where id=?";
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getNit());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getCelular());
            ps.setInt(5, cliente.getId());

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
            String sql = "delete from clientes where id =?";
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
    public Cliente getById(int id) throws Exception {
        Cliente cli = new Cliente();
        try {
            String sql = "select * from clientes where id =?";
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cli.setId(rs.getInt("id"));
                cli.setNombre(rs.getString("nombre"));
                cli.setNit(rs.getString("nit"));
                cli.setCelular(rs.getString("telefono"));
                cli.setCelular(rs.getString("celular"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return cli;
    }

    @Override
    public List<Cliente> getAll() throws Exception {
        List<Cliente> lista = null;
        try {
            String sql = "select * from clientes";
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Cliente>();
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setId(rs.getInt("id"));
                cli.setNombre(rs.getString("nombre"));
                cli.setNit(rs.getString("nit"));
                cli.setTelefono(rs.getString("telefono"));
                cli.setCelular(rs.getString("celular"));

                lista.add(cli);
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

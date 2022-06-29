
package com.emergentes.dao;

import com.emergentes.modelo.Usuario;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gualbert
 */
public class UsuarioDAOimpl extends ConexionDB implements UsuarioDAO{

    @Override
    public void insert(Usuario usuario) throws Exception {
        try {
            String sql = "insert into usuarios(nombres,apellidos,ci,telefono,correo,password,foto,rol) values (?,?,?,?,?,md5(?),?,?)";
                          
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getCi());
            ps.setString(4, usuario.getTelefono());
            ps.setString(5, usuario.getCorreo());
            ps.setString(6, usuario.getPassword());
            ps.setString(7, usuario.getFoto());
            ps.setString(8, usuario.getRol());
                        
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Usuario usuario) throws Exception {
        try {
            String sql = "update usuarios set nombres=?,apellidos=?,ci=?,telefono=?,correo=?,password=md5(?),foto=?,rol=? where id=?";
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getCi());
            ps.setString(4, usuario.getTelefono());
            ps.setString(5, usuario.getCorreo());
            ps.setString(6, usuario.getPassword());
            ps.setString(7, usuario.getFoto());
            ps.setString(8, usuario.getRol());
            ps.setInt(9, usuario.getId());

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
            String sql = "delete from usuarios where id =?";
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
    public Usuario getById(int id) throws Exception {
         Usuario user = new Usuario();
        try {
            String sql = "select * from usuarios where id =?";
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setNombre(rs.getString("nombres"));
                user.setApellido(rs.getString("apellidos"));
                user.setCi(rs.getString("ci"));
                user.setTelefono(rs.getString("telefono"));
                user.setCorreo(rs.getString("correo"));
                user.setPassword(rs.getString("password"));
                user.setPassword(rs.getString("foto"));
                user.setRol(rs.getString("rol"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return user;
    }

    @Override
    public List<Usuario> getAll() throws Exception {
        List<Usuario> lista = null;
        try {
            String sql = "select * from usuarios";
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Usuario>();
            while (rs.next()) {
                Usuario user = new Usuario();
                
                user.setId(rs.getInt("id"));
                user.setNombre(rs.getString("nombres"));
                user.setApellido(rs.getString("apellidos"));
                user.setCi(rs.getString("ci"));
                user.setTelefono(rs.getString("telefono"));
                user.setCorreo(rs.getString("correo"));
                user.setPassword(rs.getString("password"));
                user.setPassword(rs.getString("foto"));
                user.setRol(rs.getString("rol"));

                lista.add(user);
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

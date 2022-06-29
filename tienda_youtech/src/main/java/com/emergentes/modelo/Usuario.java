
package com.emergentes.modelo;

/**
 *
 * @author Gualbert
 */
public class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private String ci;
    private String telefono;
    private String correo;
    private String password;
    private String foto;
    private String rol;

    public Usuario() {
        this.id = 0;
        this.nombre = "";
        this.apellido = "";
        this.ci = "";
        this.telefono = "";
        this.correo = "";
        this.password = "";
        this.foto = "";
        this.rol = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
            
}

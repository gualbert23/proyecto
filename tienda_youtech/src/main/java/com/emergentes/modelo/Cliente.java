
package com.emergentes.modelo;

/**
 *
 * @author Gualbert
 */
public class Cliente {
    private int id;
    private String nombre;
    private String nit;
    private String telefono;
    private String celular;

    public Cliente() {
        this.id = 0;
        this.nombre = "";
        this.nit = "0";
        this.telefono = "";
        this.celular = "";
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

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    
    
}

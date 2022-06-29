
package com.emergentes.modelo;

/**
 *
 * @author Gualbert
 */
public class Proveedor {
    private int id;
    private String empresa;
    private String nit;
    private String telefono;
    private String direccion;
    private String encargado;
    private String ci;
    private String celular;

    public Proveedor() {
        this.id = 0;
        this.empresa = "";
        this.nit = "0";
        this.telefono = "";
        this.direccion = "";
        this.encargado = "";
        this.ci = "0";
        this.celular = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    
    
}

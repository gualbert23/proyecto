
package com.emergentes.modelo;

/**
 *
 * @author Gualbert
 */
public class Inventario {
    private int id;
    private int id_producto;
    private int entrada;
    private int salida;
    private int stock;
    private float precio_venta;
    private float precio_compra;
    private String ubicacion;
    
    private String codigoPro;
    private String marcaPro;
    private String productoPro;
    private String descripcionPro;

    public Inventario() {
        this.id = 0;
        this.id_producto = 0;
        this.entrada = 0;
        this.salida = 0;
        this.stock = 0;
        this.precio_venta = 0;
        this.precio_compra = 0;
        this.ubicacion = "";
        this.codigoPro = "";
        this.marcaPro = "";
        this.productoPro = "";
        this.descripcionPro = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getEntrada() {
        return entrada;
    }

    public void setEntrada(int entrada) {
        this.entrada = entrada;
    }

    public int getSalida() {
        return salida;
    }

    public void setSalida(int salida) {
        this.salida = salida;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(float precio_venta) {
        this.precio_venta = precio_venta;
    }

    public float getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(float precio_compra) {
        this.precio_compra = precio_compra;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getCodigoPro() {
        return codigoPro;
    }

    public void setCodigoPro(String codigoPro) {
        this.codigoPro = codigoPro;
    }

    public String getMarcaPro() {
        return marcaPro;
    }

    public void setMarcaPro(String marcaPro) {
        this.marcaPro = marcaPro;
    }

    public String getProductoPro() {
        return productoPro;
    }

    public void setProductoPro(String productoPro) {
        this.productoPro = productoPro;
    }

    public String getDescripcionPro() {
        return descripcionPro;
    }

    public void setDescripcionPro(String descripcionPro) {
        this.descripcionPro = descripcionPro;
    }
    
    
    
    
    
}

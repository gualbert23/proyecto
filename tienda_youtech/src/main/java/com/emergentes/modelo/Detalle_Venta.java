
package com.emergentes.modelo;

/**
 *
 * @author Gualbert
 */
public class Detalle_Venta {
    private int id;
    private int id_inventario;
    private int cantidad;
    private float subTotal;
    
    private String codigoPro;
    private String marcaPro;
    private String nombrePro;
    private String detallePro;
    
    private int stok;
    private float precioVenta;

    public Detalle_Venta() {
        this.id = 0;
        this.id_inventario = 0;
        this.cantidad = 0;
        this.subTotal = 0;
        
        this.codigoPro = "";
        this.marcaPro = "";
        this.nombrePro = "";
        this.detallePro = "";
        this.stok = 0;
        this.precioVenta = 0;
                
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_inventario() {
        return id_inventario;
    }

    public void setId_inventario(int id_inventario) {
        this.id_inventario = id_inventario;
    }
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
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

    public String getNombrePro() {
        return nombrePro;
    }

    public void setNombrePro(String nombrePro) {
        this.nombrePro = nombrePro;
    }

    public String getDetallePro() {
        return detallePro;
    }

    public void setDetallePro(String detallePro) {
        this.detallePro = detallePro;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }
    
    
    
}



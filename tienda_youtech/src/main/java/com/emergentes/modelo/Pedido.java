
package com.emergentes.modelo;

public class Pedido {
    private int id;
    private int id_venta;
    private int id_detalle;

    public Pedido() {
        this.id = 0;
        this.id_venta = 0;
        this.id_detalle = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(int id_detalle) {
        this.id_detalle = id_detalle;
    }
    
    
    
    
}

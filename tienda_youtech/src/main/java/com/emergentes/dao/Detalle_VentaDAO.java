
package com.emergentes.dao;

import com.emergentes.modelo.Detalle_Venta;
import java.util.List;

/**
 *
 * @author Gualbert
 */
public interface Detalle_VentaDAO {
    public void  insert(Detalle_Venta detalle_venta) throws Exception;
    public void  update(Detalle_Venta detalle_venta) throws Exception;
    public void  delete(int id) throws Exception;
    public Detalle_Venta  getById(int id) throws Exception;
    public List<Detalle_Venta>getAll() throws Exception;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.services;

import ec.edu.espe.dao.ProductoFacade;
import ec.edu.espe.dao.ProductoKardexFacade;
import ec.edu.espe.model.Producto;
import ec.edu.espe.model.ProductoKardex;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import java.lang.RuntimeException;
import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author esteban
 */
@Stateless
@LocalBean
public class ProductoServicio {

    private static final Logger LOG = Logger.getLogger(ProductoServicio.class.getName());
    
    @EJB
    private ProductoFacade productoDao;
    private ProductoKardexFacade productoKardexDao;

    public List<Producto> listarTodos() {
        return productoDao.findAll();
    }
    
    public void descontarExistencia(String id, Integer cantidad) throws RuntimeException {
        Producto producto = productoDao.find(id);
        if (producto == null) {
            throw new RuntimeException();
        }
        List<ProductoKardex> productosKardex = producto.getProductoKardexList();
        if(producto.getExistencia()<cantidad){
            LOG.info("Excepcion");
            throw new RuntimeException();
        }else{
            ProductoKardex productoKardex = new ProductoKardex();
            productoKardex.setProducto(producto);
            productoKardex.setFecha(new Date());
            productoKardex.setCantidad(cantidad);
            productoKardex.setExistencia(producto.getExistencia());
            productosKardex.add(productoKardex);
            producto.setProductoKardexList(productosKardex);
            producto.setExistencia(producto.getExistencia() - cantidad);
            productoDao.edit(producto);
        }
    }
}
